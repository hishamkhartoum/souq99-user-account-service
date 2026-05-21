package com.souq99.useraccountservice.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Currency {
    USD("enum.currency.usd"),
    EUR("enum.currency.eur"),
    SDG("enum.currency.sdg"),
    EGP("enum.currency.egp"),
    GBP("enum.currency.gbp"),
    SAR("enum.currency.sar");

    private final String messageKey;
}
