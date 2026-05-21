package com.souq99.useraccountservice.service.impl;

import com.souq99.useraccountservice.domain.dto.CaptchaResponse;
import com.souq99.useraccountservice.service.CaptchaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Value("${recaptcha.secret}")
    private String secret;

    @Value("${recaptcha.verify.url}")
    private String verifyUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean verifyToken(String token) {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("secret", secret);
        params.add("response", token);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<>(params, headers);

        ResponseEntity<CaptchaResponse> response =
                restTemplate.postForEntity(verifyUrl, request, CaptchaResponse.class);

        if (response.getBody() == null) {
            return false;
        }

        return response.getBody().isSuccess();
    }
}
