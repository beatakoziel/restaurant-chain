package com.restaurant.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "menu")
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dishId;

    @Column(nullable = false)
    private String dishName;

    @Column(nullable = false)
    private String dishDescription;

    @Column(nullable = false)
    private double grossPrice;
}
