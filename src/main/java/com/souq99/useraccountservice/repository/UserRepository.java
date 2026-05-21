package com.souq99.useraccountservice.repository;

import com.souq99.useraccountservice.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPhone(String phone);
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
