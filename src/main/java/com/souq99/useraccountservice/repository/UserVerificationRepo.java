package com.souq99.useraccountservice.repository;

import com.souq99.useraccountservice.domain.entity.UserVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserVerificationRepo extends JpaRepository<UserVerification,Long> {
    Optional<UserVerification> findByEmail(String email);
}
