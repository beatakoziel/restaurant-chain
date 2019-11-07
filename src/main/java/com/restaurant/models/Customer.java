package com.restaurant.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @OneToOne
    private User userId;

    @OneToMany(mappedBy = "reservationId")
    private Set<Reservation> reservations;


}
