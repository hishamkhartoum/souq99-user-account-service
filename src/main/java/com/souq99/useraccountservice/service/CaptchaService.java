package com.souq99.useraccountservice.service;

public interface CaptchaService {
    boolean verifyToken(String token);
}
