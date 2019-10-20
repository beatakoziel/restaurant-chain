package com.restaurant.commands;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import lombok.Value;


@Value
public class DishCommand {
    @NonNull
    private String dishName;
    @NonNull
    private String dishDescription;
    @NonNull
    private double grossPrice;

    @JsonCreator
    public DishCommand(@JsonProperty(value = "dishName", required = true) String dishName,
                       @JsonProperty(value = "dishDescription", required = true) String dishDescription,
                       @JsonProperty(value = "grossPrice", required = true) double grossPrice) {
        this.dishName = dishName;
        this.dishDescription = dishDescription;
        this.grossPrice = grossPrice;
    }
}
