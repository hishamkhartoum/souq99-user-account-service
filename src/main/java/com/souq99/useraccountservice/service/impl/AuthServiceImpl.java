package com.souq99.useraccountservice.service.impl;

import com.souq99.useraccountservice.convertor.RegistrationRequestToUserConvertor;
import com.souq99.useraccountservice.domain.dto.*;
import com.souq99.useraccountservice.domain.entity.Role;
import com.souq99.useraccountservice.domain.entity.User;
import com.souq99.useraccountservice.domain.entity.UserVerification;
import com.souq99.useraccountservice.exception.BadRequestException;
import com.souq99.useraccountservice.exception.NotFoundException;
import com.souq99.useraccountservice.kafka.dto.UserRegistrationEvent;
import com.souq99.useraccountservice.kafka.service.AccountEventPublisher;
import com.souq99.useraccountservice.repository.PasswordResetRepository;
import com.souq99.useraccountservice.repository.RoleRepository;
import com.souq99.useraccountservice.repository.UserRepository;
import com.souq99.useraccountservice.repository.UserVerificationRepo;
import com.souq99.useraccountservice.security.JwtService;
import com.souq99.useraccountservice.service.AuthService;
import com.souq99.useraccountservice.service.CodeGenerator;
import com.souq99.useraccountservice.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserVerificationRepo userVerificationRepo;
    private final CodeGenerator codeGenerator;
    private final PasswordResetRepository passwordResetRepository;
    private final JwtService jwtService;
    private final MessageService messageService;
    private final RegistrationRequestToUserConvertor requestToUserConvertor;
    private final AccountEventPublisher accountEventPublisher;

    @Value("${password.reset.link}")
    private String resetLink;

    @Value("${verify.link}")
    private String verifyLink;

    @Transactional
    @Override
    public Response<String> register(RegistrationRequest request) {
        Locale locale = getLocale();
        log.info("Registering user with email: {}", request.getEmail());

        Optional<User> existingUserOpt = userRepository.findByPhone(request.getPhone());
        if (existingUserOpt.isPresent()) {
            return handleExistingUser(existingUserOpt.get(), request, locale);
        }

        return createNewUser(request, locale);
    }

    @Override
    public Response<LoginResponse> login(LoginRequest loginRequest) {
        Locale locale = getLocale();
        log.info("Login user with phone {}", loginRequest.getPhone());
        User user = userRepository.findByPhone(loginRequest.getPhone())
                .orElseThrow(() -> new NotFoundException(messageService.getLocalizedMessage("user.not.found", locale)));
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new BadRequestException(messageService.getLocalizedMessage("password.mismatch", locale));
        }
        String token = jwtService.generateToken(user.getEmail(),user.getRole());
        LoginResponse loginResponse = LoginResponse.builder()
                .role(user.getRole().getName())
                .token(token)
                .build();
        return Response.<LoginResponse>builder()
                .statusCode(200)
                .message(messageService.getLocalizedMessage("login.success", locale))
                .data(loginResponse)
                .build();
    }

    @Transactional
    @Override
    public Response<?> verifyAccountBySMS(VerifyAccountDTO verifyAccount) {
        Locale locale = getLocale();
        User user = userRepository.findByPhone(verifyAccount.getPhone())
                .orElseThrow(() -> new NotFoundException(messageService.getLocalizedMessage("user.not.found.generic", locale)));
        UserVerification userVerification = userVerificationRepo.findByEmail(user.getEmail())
                .orElseThrow(() -> new NotFoundException(messageService.getLocalizedMessage("user.cannot.be.verified", locale)));
        if (!userVerification.getCode().equals(verifyAccount.getCode())) {
            if (userVerification.getFailedAttempts() < 3) {
                userVerification.setFailedAttempts(userVerification.getFailedAttempts() + 1);
                userVerificationRepo.save(userVerification);
            } else {
                userVerificationRepo.delete(userVerification);
                userRepository.delete(user);
            }
            return Response.builder()
                    .message(messageService.getLocalizedMessage("verification.failed", locale))
                    .statusCode(HttpStatus.FORBIDDEN.value())
                    .build();
        } else {
            userVerificationRepo.delete(userVerification);
            user.setActive(true);
            userRepository.save(user);
            return Response.builder()
                    .message(messageService.getLocalizedMessage("verification.success", locale))
                    .statusCode(200)
                    .build();
        }
    }

    private void sendRegistrationSMS(RegistrationRequest request, User user, String code) {

        log.info("Sending code to phone number: {}",user.getPhone());
        UserRegistrationEvent verificationCode = UserRegistrationEvent.builder()
                .recipientPhone(user.getPhone())
                .message("Your verification code for Souq99 is: ")
                .templateVariables(Map.of(
                        "name", request.getName(),
                        "code", code
                ))
                .build();
        accountEventPublisher.publishedUserRegistrationEmailEvent(verificationCode);
    }

    private LocalDateTime calculateExpiryDate() {
        return LocalDateTime.now().plusHours(5);
    }

    private Locale getLocale() {
        try {
            ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            return attrs.getRequest().getLocale();
        } catch (Exception e) {
            return Locale.US;
        }
    }

    private Response<String> handleExistingUser(User user,
                                                RegistrationRequest request,
                                                Locale locale) {

        if (user.isEmailVerified()) {
            throw new BadRequestException(
                    messageService.getLocalizedMessage("user.email.exists", locale)
            );
        }

        String code = codeGenerator.generateUniqueNumbers();
        String email = user.getEmail();

        UserVerification verification = userVerificationRepo.findByEmail(email)
                .map(v -> {
                    log.info("Resending verification code to existing user: {}", email);
                    v.setCode(code);
                    return v;
                })
                .orElseGet(() -> UserVerification.builder()
                        .email(email)
                        .failedAttempts(0L)
                        .code(code)
                        .build()
                );

        userVerificationRepo.save(verification);

        sendRegistrationSMS(request, user, code);

        return Response.<String>builder()
                .statusCode(200)
                .message(messageService.getLocalizedMessage("verification.send", locale))
                .data(email)
                .build();
    }

    private Response<String> createNewUser(RegistrationRequest request, Locale locale) {

        Role role = roleRepository.findByName("CUSTOMER")
                .orElseThrow(() -> new NotFoundException(
                        messageService.getLocalizedMessage("customer.role.not.found", locale)
                ));

        User newUser = requestToUserConvertor.convert(request);
        assert newUser != null;
        newUser.setRole(role);
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(newUser);

        log.info("New user registered: {} with role {}", savedUser.getEmail(), role.getName());

        String code = codeGenerator.generateUniqueNumbers();

        UserVerification verification = UserVerification.builder()
                .email(savedUser.getEmail())
                .failedAttempts(0L)
                .code(code)
                .build();

        userVerificationRepo.save(verification);

        sendRegistrationSMS(request, savedUser, code);

        log.info("Verification email sent to: {}", savedUser.getEmail());

        return Response.<String>builder()
                .statusCode(200)
                .message(messageService.getLocalizedMessage("registration.success", locale))
                .data(savedUser.getEmail())
                .build();
    }
}
