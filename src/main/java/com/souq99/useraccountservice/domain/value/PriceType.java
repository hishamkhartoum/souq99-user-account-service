package com.souq99.useraccountservice.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PriceType {
    FIXED("enum.price_type.fixed"),
    NEGOTIABLE("enum.price_type.negotiable"),
    ON_CONTACT("enum.price_type.on_contact");

    private final String messageKey;
}
