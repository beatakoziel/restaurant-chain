package com.restaurant.models;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "customer")
public class Customer
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @OneToMany(mappedBy = "reservationId")
    Set<Reservation> reservations = new TreeSet<>();

    @OneToOne
    Person personId;

}
