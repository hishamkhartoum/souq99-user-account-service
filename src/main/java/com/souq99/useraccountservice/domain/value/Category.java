package com.souq99.useraccountservice.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    VEHICLES("enum.category.vehicles"),
    ELECTRONICS_AND_HOME_APPLIANCES("enum.category.electronics_and_home_appliances"),
    HOUSING("enum.category.housing"),
    HOME_AND_GARDEN("enum.category.home_and_garden"),
    FASHION_AND_KIDS("enum.category.fashion_and_kids"),
    BEAUTY_AND_HEALTH("enum.category.beauty_and_health"),
    FOOD_AND_GROCERIES("enum.category.food_and_groceries"),
    SERVICES("enum.category.services"),
    JOBS("enum.category.jobs"),
    PETS_AND_ACCESSORIES("enum.category.pets_and_accessories"),
    ENTERTAINMENT("enum.category.entertainment"),
    ENTERTAINMENT_BOOKS_AND_COLLECTIONS("enum.category.entertainment_books_and_collections"),
    SPORTS_AND_FITNESS("enum.category.sports_and_fitness"),
    BUSINESS_AND_EQUIPMENT("enum.category.business_and_equipment");

    private final String messageKey;
}
