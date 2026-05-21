package com.souq99.useraccountservice.kafka.service;

import com.souq99.useraccountservice.kafka.dto.UserRegistrationEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private static final String USER_TOPIC = "user-registration-topic";

    public void publishedUserRegistrationEmailEvent(UserRegistrationEvent event) {
        try {
            kafkaTemplate.send(USER_TOPIC, event.getRecipientPhone(), event);
            log.info("Event Sent Out {}", event.getRecipientPhone());

        } catch (Exception e) {
            log.info("Failed to publish user registered event: {}", e.getMessage());
        }
    }
}
