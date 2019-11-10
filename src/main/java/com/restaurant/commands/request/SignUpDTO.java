package com.restaurant.commands.request;

import lombok.Data;

@Data
public class SignUpDTO {
    private String username;
    private String email;
    private String phone;
    private String password;
}
