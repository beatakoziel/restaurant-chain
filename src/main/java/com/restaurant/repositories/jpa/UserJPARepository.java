package com.restaurant.repositories.jpa;

import com.restaurant.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, Long> {
}
