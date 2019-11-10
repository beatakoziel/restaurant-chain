package com.restaurant.services;

import com.restaurant.commands.request.EmployeeDTO;
import com.restaurant.repositories.EmployeeRepository;
import com.restaurant.views.EmployeeView;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<EmployeeView> createEmployee(String username, EmployeeDTO employeeDTO) {
        return employeeRepository.saveEmployee(username, employeeDTO);
    }
}
