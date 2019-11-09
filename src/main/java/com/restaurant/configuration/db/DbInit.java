package com.restaurant.configuration.db;

import com.restaurant.models.authority.Role;
import com.restaurant.models.authority.RoleName;
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
        roleJPARepository.saveAll(Arrays.asList(new Role(RoleName.ROLE_ADMIN), new Role(RoleName.ROLE_USER), new Role(RoleName.ROLE_COOK), new Role(RoleName.ROLE_WAITER)));
    }
}
