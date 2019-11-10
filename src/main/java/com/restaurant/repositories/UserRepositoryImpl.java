package com.restaurant.repositories;

import com.restaurant.commands.request.SignUpDTO;
import com.restaurant.models.User;
import com.restaurant.models.authority.Role;
import com.restaurant.models.authority.RoleName;
import com.restaurant.repositories.jpa.RoleJPARepository;
import com.restaurant.repositories.jpa.UserJPARepository;
import com.restaurant.utility.mappers.UserMapper;
import com.restaurant.views.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJPARepository userRepository;

    private final RoleJPARepository roleRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<String> saveUser(SignUpDTO signUpDTO) {

        if (existsByUsername(signUpDTO.getUsername())) {
            return new ResponseEntity<>("Username already used", HttpStatus.BAD_REQUEST);
        }
        if (existsByEmail(signUpDTO.getEmail())) {
            return new ResponseEntity<>("Email already used", HttpStatus.BAD_REQUEST);
        }

        Set<Role> roles = new HashSet<>();

        signUpDTO.getRoles().forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Admin role not found"));
                    roles.add(adminRole);
                    break;
                case "cook":
                    Role cookRole = roleRepository.findByName(RoleName.ROLE_COOK)
                            .orElseThrow(() -> new RuntimeException("Cook role not found"));
                    roles.add(cookRole);
                    break;
                case "waiter":
                    Role waiterRole = roleRepository.findByName(RoleName.ROLE_WAITER)
                            .orElseThrow(() -> new RuntimeException("Waiter role not found"));
                    roles.add(waiterRole);
                    break;
                case "user":
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("User role not found"));
                    roles.add(userRole);
                    break;

            }
        });


        User user = new User(signUpDTO.getUsername(),
                passwordEncoder.encode(signUpDTO.getPassword()),
                signUpDTO.getEmail(),
                signUpDTO.getPhone(),
                roles);

        userRepository.save(user);
        return ResponseEntity.ok("User registered.");
    }

    @Override
    public UserPrincipal updateUser(Long userId, SignUpDTO signupDTO) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found" + signupDTO.getUsername()));
        user.setPassword(signupDTO.getPassword());
        user.setEmail(signupDTO.getEmail());
        user.setPhone(signupDTO.getPhone());
        return UserMapper.mapUserToUserPrincipal(user);
    }

    @Override
    public UserPrincipal getUserById(Long userId) {
        return userRepository.findById(userId).map(UserMapper::mapUserToUserPrincipal).orElseThrow(() -> new UsernameNotFoundException("User not found" + userId));
    }

    @Override
    public List<UserPrincipal> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::mapUserToUserPrincipal).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserPrincipal findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return UserPrincipal.build(user);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}
