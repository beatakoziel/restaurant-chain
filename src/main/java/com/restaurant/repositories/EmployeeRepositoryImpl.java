package com.restaurant.repositories;

import com.restaurant.commands.request.EmployeeDTO;
import com.restaurant.models.Employee;
import com.restaurant.models.User;
import com.restaurant.models.authority.Role;
import com.restaurant.models.authority.RoleName;
import com.restaurant.repositories.jpa.EmployeeJPARepository;
import com.restaurant.repositories.jpa.RoleJPARepository;
import com.restaurant.repositories.jpa.UserJPARepository;
import com.restaurant.utility.mappers.EmployeeMapper;
import com.restaurant.views.EmployeeView;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashSet;

@Repository
@AllArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    UserJPARepository userRepository;
    EmployeeJPARepository employeeJPARepository;
    RoleJPARepository roleJPARepository;


    @Override
    @Transactional
    public ResponseEntity<EmployeeView> saveEmployee(String username, EmployeeDTO employeeDTO) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found" + username));


        employeeDTO.getRoles().forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleJPARepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Admin role not found"));
                    user.getRoles().add(adminRole);
                    break;
                case "waiter":
                    Role waiterRole = roleJPARepository.findByName(RoleName.ROLE_WAITER)
                            .orElseThrow(() -> new RuntimeException("Waiter role not found"));
                    user.getRoles().add(waiterRole);
                    break;
                case "cook":
                    Role cookRole = roleJPARepository.findByName(RoleName.ROLE_COOK)
                            .orElseThrow(() -> new RuntimeException("Cook role not found"));
                    user.getRoles().add(cookRole);
                    break;
            }
        });

        userRepository.save(user);
        Employee employee = Employee.builder().userId(user)
                .name(employeeDTO.getName())
                .surname(employeeDTO.getSurname())
                .salary(employeeDTO.getSalary())
                .orderSet(new HashSet<>())
                .build();

        employeeJPARepository.save(employee);

        return ResponseEntity.ok(EmployeeMapper.mapEmployeeToEmployeeView(employee));
    }
}