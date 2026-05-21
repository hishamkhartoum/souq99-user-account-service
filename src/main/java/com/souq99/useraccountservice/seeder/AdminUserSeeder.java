package com.souq99.useraccountservice.seeder;

import com.souq99.useraccountservice.domain.entity.Role;
import com.souq99.useraccountservice.domain.entity.User;
import com.souq99.useraccountservice.domain.value.AuthMethod;
import com.souq99.useraccountservice.repository.RoleRepository;
import com.souq99.useraccountservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminUserSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        Role adminRole = roleRepository.findByName("ADMIN")
                .orElseGet(() -> roleRepository.save(
                        Role.builder()
                                .name("ADMIN")
                                .build()
                ));

        roleRepository.findByName("CUSTOMER")
                .orElseGet(() -> roleRepository.save(
                        Role.builder()
                                .name("CUSTOMER")
                                .build()
                ));

        String adminEmail = "admin@salfour.com";

        if (userRepository.existsByEmail(adminEmail)) {
            return;
        }

        User admin = new User();
        admin.setEmail(adminEmail);
        admin.setName("Admin admin");
        admin.setPhone("+351000000000");
        admin.setPassword(passwordEncoder.encode("1234"));
        admin.setProvider(AuthMethod.LOCAL);
        admin.setRole(adminRole);
        admin.setActive(true);

        userRepository.save(admin);
    }
}
