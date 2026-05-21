package com.souq99.useraccountservice.service;

import com.souq99.useraccountservice.repository.PasswordResetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
@RequiredArgsConstructor
public class CodeGenerator {

    private final PasswordResetRepository passwordResetRepository;

    private static final String ALPHA_NUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String NUMBERS_NUMERIC = "0123456789";
    private static final int CODE_LENGTH = 6;

    public String generateCode(){
        return generateRandomCode();
    }
    public String generateUniqueNumbers() {
        String code;
        do {
            code = generateRandomNUM();
        } while (passwordResetRepository.findByCode(code).isPresent());

        return code;
    }

    private String generateRandomCode() {

        StringBuilder sb = new StringBuilder(CODE_LENGTH);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(ALPHA_NUMERIC.length());
            sb.append(ALPHA_NUMERIC.charAt(index));
        }
        return sb.toString();
    }
    private String generateRandomNUM() {

        StringBuilder sb = new StringBuilder(CODE_LENGTH);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(NUMBERS_NUMERIC.length());
            sb.append(NUMBERS_NUMERIC.charAt(index));
        }
        return sb.toString();
    }
}









