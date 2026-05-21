package com.souq99.useraccountservice.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotificationType {
    EMAIL("enum.notification_type.email"),
    SMS("enum.notification_type.sms"),
    IN_APP("enum.notification_type.in_app");

    private final String messageKey;
}
