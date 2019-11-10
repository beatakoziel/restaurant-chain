package com.restaurant.services;

import com.restaurant.commands.request.SignUpDTO;
import com.restaurant.views.UserPrincipal;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<String> createUser(SignUpDTO signupDTO);

    UserPrincipal updateUser(Long userId, SignUpDTO signupDTO);

    UserPrincipal getUserById(Long userId);

    List<UserPrincipal> getAllUsers();

}
