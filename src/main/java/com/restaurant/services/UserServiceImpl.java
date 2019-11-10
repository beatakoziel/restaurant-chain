package com.restaurant.services;

import com.restaurant.commands.request.SignUpDTO;
import com.restaurant.repositories.UserRepository;
import com.restaurant.views.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    @Override
    public ResponseEntity<String> createUser(SignUpDTO signupDTO) {
        return userRepository.saveUser(signupDTO);
    }

    @Override
    public UserPrincipal updateUser(Long userId, SignUpDTO signupDTO) {
        return userRepository.updateUser(userId, signupDTO);
    }

    @Override
    public UserPrincipal getUserById(Long userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public List<UserPrincipal> getAllUsers() {
        return userRepository.getAllUsers();
    }

}
