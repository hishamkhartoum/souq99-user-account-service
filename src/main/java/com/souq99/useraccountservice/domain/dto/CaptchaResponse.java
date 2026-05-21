package com.souq99.useraccountservice.domain.dto;

import java.util.List;

public class CaptchaResponse {
    private boolean success;
    private float score;
    private String action;
    private String hostname;
    private List<String> errorCodes;

    public boolean isSuccess() {
        return success;
    }

    public float getScore() {
        return score;
    }

    public String getHostname() {
        return hostname;
    }
}
