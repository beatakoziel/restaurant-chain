package com.restaurant.models;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @OneToMany(mappedBy = "reservationId")
    private Set<Reservation> reservations = new TreeSet<>();

    @OneToOne
    private User user;

}
