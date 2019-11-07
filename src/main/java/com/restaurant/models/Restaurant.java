package com.restaurant.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restaurantId;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @OneToMany(mappedBy = "restaurantId")
    private Set<TableType> tables;
}
