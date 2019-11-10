package com.restaurant.services;

import com.restaurant.commands.request.EmployeeDTO;
import com.restaurant.views.EmployeeView;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

    ResponseEntity<EmployeeView> createEmployee(String username, EmployeeDTO employeeDTO);
}
