package com.restaurant.commands.request;

import lombok.Data;

import java.util.Set;

@Data
public class SignUpDTO {
    private String username;
    private String email;
    private String phone;
    private String password;
    private Set<String> roles;

}
