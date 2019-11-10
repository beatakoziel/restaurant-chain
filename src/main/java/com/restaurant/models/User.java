package com.restaurant.models;

import com.restaurant.models.authority.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @Column(nullable = false)
    private String username;

    @NotBlank
    private String password;

    @Email
    @NotBlank
    private String email;

    @Column(nullable = false)
    private String phone;

    @ManyToMany
    private Set<Role> roles;

    public User(String username, @NotBlank String password, @Email String email, String phone, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
    }

    public Long getPersonId() {
        return personId;
    }
}
