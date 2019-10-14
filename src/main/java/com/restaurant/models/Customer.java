package com.restaurant.models;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "customer")
public class Customer extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    @OneToMany(mappedBy = "reservationId")
    Set<Reservation> reservations = new TreeSet<>();
}
