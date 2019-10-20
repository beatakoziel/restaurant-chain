package com.restaurant.controllers;

import com.restaurant.models.User;
import com.restaurant.repositories.jpa.UserJPARepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserJPARepository repository;

    public UserController(UserJPARepository repository) {
        this.repository = repository;
    }

    @PostMapping("/users")
    public void createUser(@RequestParam String name, @RequestParam String surname, @RequestParam String password, @RequestParam String email, @RequestParam String phone) {
        User user = new User(name, surname, password, email, phone);
        repository.save(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return repository.findAll();
    }
}
