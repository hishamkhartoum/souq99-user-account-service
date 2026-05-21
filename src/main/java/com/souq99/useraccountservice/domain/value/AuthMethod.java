package com.souq99.useraccountservice.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthMethod {
    LOCAL("enum.auth_method.local"),
    GOOGLE("enum.auth_method.google"),
    FACEBOOK("enum.auth_method.facebook");

    private final String messageKey;
}
