package com.restaurant.controllers;

import com.restaurant.services.UserService;
import com.restaurant.views.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private UserService userService;

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public Iterable<UserPrincipal> getAllUsers(){
        return userService.getAllUsers();
    }

//    @PostMapping("workers")
//    public ResponseEntity createEmployee(){
//
//        return
//    }

}
