package com.restaurant.controllers;

import com.restaurant.repositories.jpa.UserJPARepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserJPARepository repository;

    public UserController(UserJPARepository repository) {
        this.repository = repository;
    }


}
