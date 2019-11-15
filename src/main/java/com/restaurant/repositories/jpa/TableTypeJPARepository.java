package com.restaurant.repositories.jpa;

import com.restaurant.models.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableTypeJPARepository extends JpaRepository<Table, Integer> {
}
