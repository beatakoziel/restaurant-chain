package com.restaurant.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @OneToOne
    private User userId;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @Column(nullable = false)
    private double salary;

    @OneToMany(mappedBy = "orderId")
    private Set<Order> orderSet;



}
