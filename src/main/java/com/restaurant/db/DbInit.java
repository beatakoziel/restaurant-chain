package com.restaurant.db;

import com.restaurant.models.authority.Role;
import com.restaurant.repositories.jpa.RoleJPARepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DbInit implements CommandLineRunner {

    private RoleJPARepository roleJPARepository;


    public DbInit(RoleJPARepository repository) {
        this.roleJPARepository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        roleJPARepository.saveAll(Arrays.asList(new Role("ROLE_USER"), new Role("ROLE_WAITER"), new Role("ROLE_COOK"), new Role("ROLE_ADMIN")));
    }
}
