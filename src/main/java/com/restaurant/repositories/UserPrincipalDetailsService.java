package com.restaurant.repositories;

import com.restaurant.models.User;
import com.restaurant.repositories.jpa.UserJPARepository;
import com.restaurant.views.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserJPARepository userRepository;

    public UserPrincipalDetailsService(UserJPARepository repo) {
        userRepository = repo;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return UserPrincipal.build(user);
    }
}
