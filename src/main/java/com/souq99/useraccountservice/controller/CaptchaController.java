package com.souq99.useraccountservice.controller;


import com.souq99.useraccountservice.domain.dto.CaptchaRequest;
import com.souq99.useraccountservice.service.CaptchaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/captcha")
public class CaptchaController {

    private final CaptchaService captchaService;

    public CaptchaController(CaptchaService captchaService) {
        this.captchaService = captchaService;
    }

    @PostMapping("/verify")
    public boolean verifyCaptcha(@RequestBody CaptchaRequest request) {
        return captchaService.verifyToken(request.getToken());
    }
}
