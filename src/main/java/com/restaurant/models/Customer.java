package com.restaurant.models;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @OneToMany(mappedBy = "reservationId")
    private Set<Reservation> reservations = new TreeSet<>();

    @OneToOne
    private User userId;

}
