package com.restaurant.models;

import com.restaurant.models.enums.JobPosition;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Enumerated(EnumType.STRING)
    private JobPosition jobPosition;

    @Column(nullable = false)
    private double salary;

    @OneToMany(mappedBy = "orderId")
    Set<Order> orderSet = new HashSet<>();

    @OneToOne
    Person personId;

}
