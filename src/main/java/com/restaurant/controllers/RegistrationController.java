package com.restaurant.controllers;


import com.restaurant.models.User;
import com.restaurant.models.authority.Role;
import com.restaurant.models.authority.RoleName;
import com.restaurant.repositories.jpa.RoleJPARepository;
import com.restaurant.repositories.jpa.UserJPARepository;
import com.restaurant.commands.request.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class RegistrationController {

    @Autowired
    private UserJPARepository userRepository;

    @Autowired
    private RoleJPARepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignupDTO signupDTO) {
        if (userRepository.existsByUsername(signupDTO.getUsername())) {
            return new ResponseEntity<>("Username already used", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(signupDTO.getEmail())) {
            return new ResponseEntity<>("Email already used", HttpStatus.BAD_REQUEST);
        }

        Set<Role> roles = new HashSet<>();

        signupDTO.getRoles().forEach(role -> {
            switch (role) {
                case "admin" :
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Admin role not found"));
                    roles.add(adminRole);
                    break;
                case "user" :
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("User role not found"));
                    roles.add(userRole);
                    break;
                case "waiter" :
                    Role waiterRole = roleRepository.findByName(RoleName.ROLE_WAITER)
                            .orElseThrow(() -> new RuntimeException("Waiter role not found"));
                    roles.add(waiterRole);
                    break;
                case "cook" :
                    Role cookRole = roleRepository.findByName(RoleName.ROLE_COOK)
                            .orElseThrow(() -> new RuntimeException("Cook role not found"));
                    roles.add(cookRole);
                    break;
            }
        });


        User user = new User(signupDTO.getUsername(),passwordEncoder.encode(signupDTO.getPassword()),
                signupDTO.getEmail(), signupDTO.getPhone(),roles);
        userRepository.save(user);

        return ResponseEntity.ok("User registered.");
    }
}
