package com.souq99.useraccountservice.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResendVerifyCodeRequest {
    @NotBlank(message = "Phone number must not be blank")
    private String phone;
}
