package com.souq99.useraccountservice.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Duration {
    DAY("enum.duration.day"),
    WEEK("enum.duration.week"),
    MONTH("enum.duration.month"),
    THREE_MONTH("enum.duration.three_month"),
    SIX_MONTH("enum.duration.six_month"),
    YEAR("enum.duration.year");

    private final String messageKey;
}
