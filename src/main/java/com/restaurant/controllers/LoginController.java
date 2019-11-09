package com.restaurant.controllers;


import com.restaurant.configuration.jwt.JwtProvider;
import com.restaurant.commands.request.LoginDTO;
import com.restaurant.commands.response.JwtTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    JwtProvider provider;
    @Autowired
    AuthenticationManager manager;

    @PostMapping("/signin")
    public ResponseEntity authenticateUser(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = provider.genereteToken(authentication);

        return ResponseEntity.ok(new JwtTokenDTO(token));
    }
}
