package com.restaurant.repositories;

import com.restaurant.commands.request.EmployeeDTO;
import com.restaurant.views.EmployeeView;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;

public interface EmployeeRepository {
    @Transactional
    ResponseEntity<EmployeeView> saveEmployee(String username, EmployeeDTO employeeDTO);
}
