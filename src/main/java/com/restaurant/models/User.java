package com.restaurant.models;

import com.restaurant.models.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @NotBlank
    @Size(min = 5)
    private String password;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    private RoleName role;

    public User(String name, String surname, @NotBlank @Size(min = 5) String password, @Email String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}
