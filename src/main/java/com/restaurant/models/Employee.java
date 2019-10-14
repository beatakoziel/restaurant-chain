package com.restaurant.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    @Column(nullable = false)
    private String jobPosition;

    @Column(nullable = false)
    private double salary;

    @OneToMany(mappedBy = "orderId")
    Set<Order> orderSet = new HashSet<>();

}
