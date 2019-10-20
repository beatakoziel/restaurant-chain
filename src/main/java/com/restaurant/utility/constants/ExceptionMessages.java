package com.restaurant.utility.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {
    public static final String DISH_NOT_FOUND = "Dish with id %s not found";
}
