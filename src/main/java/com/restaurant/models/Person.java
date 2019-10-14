package com.restaurant.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;

@MappedSuperclass
public class Person {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;
}
