package com.souq99.useraccountservice.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Country {
    SUDAN("enum.country.sudan"),
    PORTUGAL("enum.country.portugal"),
    EGYPT("enum.country.egypt");

    private final String messageKey;
}
