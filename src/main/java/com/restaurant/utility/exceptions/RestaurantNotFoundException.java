package com.restaurant.utility.exceptions;

import static com.restaurant.utility.constants.ExceptionMessages.DISH_NOT_FOUND;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(Integer restaurantId) {
        super(String.format(DISH_NOT_FOUND, restaurantId));
    }
}
