package com.restaurant.controllers;

import com.restaurant.commands.request.EmployeeDTO;
import com.restaurant.services.EmployeeService;
import com.restaurant.services.UserService;
import com.restaurant.views.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private UserService userService;
    private EmployeeService employeeService;

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public Iterable<UserPrincipal> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/employee/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity createEmployee(@PathVariable String username, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(username, employeeDTO);
    }

    @DeleteMapping("/users/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

}
