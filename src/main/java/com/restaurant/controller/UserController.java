package com.restaurant.controller;

import com.restaurant.models.User;
import com.restaurant.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/users")
    public void createUser(@RequestParam String name, @RequestParam String surname, @RequestParam String password, @RequestParam String email,@RequestParam String phone){
        User user = new User(name,surname,password,email,phone);
        repository.save(user);
    }

    @GetMapping("/users")
    public List <User> getUsers(){
        return repository.findAll();
    }
}
