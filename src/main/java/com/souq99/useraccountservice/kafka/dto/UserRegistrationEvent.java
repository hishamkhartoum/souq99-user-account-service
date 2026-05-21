package com.souq99.useraccountservice.kafka.dto;

import com.souq99.useraccountservice.domain.value.NotificationType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistrationEvent {

    private Long id;

    @NotBlank(message = "Recipient phone is required")
    private String recipientPhone;

    private String message;

    private Map<String, Object> templateVariables;
}
