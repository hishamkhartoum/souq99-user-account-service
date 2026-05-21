package com.souq99.useraccountservice.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Condition {
    NEW("enum.condition.new"),
    USED("enum.condition.used"),
    NOT_SPECIFIED("enum.condition.not_specified"),
    USED_LIKE_NEW("enum.condition.used_like_new"),
    BROKEN("enum.condition.broken");
    private final String messageKey;
}
