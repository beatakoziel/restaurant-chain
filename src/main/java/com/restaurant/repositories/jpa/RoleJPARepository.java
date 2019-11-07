package com.restaurant.repositories.jpa;

import com.restaurant.models.authority.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJPARepository extends JpaRepository<Role,Long> {
}
