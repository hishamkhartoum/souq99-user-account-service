package com.souq99.useraccountservice.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.souq99.useraccountservice.domain.value.AuthMethod;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotNull
    @AssertTrue(message = "You must accept the terms")
    private Boolean terms;

    private AuthMethod provider;
}
