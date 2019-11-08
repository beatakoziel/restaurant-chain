package com.restaurant.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restaurantId;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @OneToMany(mappedBy = "restaurant")
    private Set<Table> tables = new HashSet<>();
}
