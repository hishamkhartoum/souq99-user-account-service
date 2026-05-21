package com.souq99.useraccountservice.service;


import com.souq99.useraccountservice.domain.dto.*;
import jakarta.validation.Valid;

public interface AuthService {
    Response<String> register(RegistrationRequest request);
    Response<LoginResponse> login(LoginRequest loginRequest);

    Response<?> verifyAccountBySMS(VerifyAccountDTO verifyAccount);
}
