package com.restaurant.repositories;

import com.restaurant.commands.DishCommand;
import com.restaurant.views.DishView;

import java.util.List;

public interface DishRepository {
    DishView saveDish(DishCommand dishCommand);

    DishView updateDish(Long dishId, DishCommand dishCommand);

    DishView getDishById(Long dishId);

    List<DishView> getAllDishes();
}
