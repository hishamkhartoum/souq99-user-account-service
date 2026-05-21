package com.souq99.useraccountservice.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PostStatus {
    DRAFT("enum.post_status.draft"),
    PUBLISHED("enum.post_status.published"),
    COMPLETED("enum.post_status.completed"),
    BLOCKED("enum.post_status.blocked"),
    EXPIRED("enum.post_status.expired");
    private final String messageKey;
}
