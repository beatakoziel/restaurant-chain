package com.restaurant.models;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dishId;

    @Column(nullable = false)
    private String dishDescription;

    @Column(nullable = false)
    private double grossPrice;

    public Menu(String dishDescription, double gorssPrice) {
        this.dishDescription = dishDescription;
        this.grossPrice = gorssPrice;
    }

}
