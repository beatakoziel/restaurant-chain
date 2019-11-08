package com.restaurant.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "reservationId")
    private Set<Reservation> reservations;


}
