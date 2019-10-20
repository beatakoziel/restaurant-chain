package com.restaurant.repositories.jpa;

import com.restaurant.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJPARepository extends JpaRepository<Customer, Long> {
}
