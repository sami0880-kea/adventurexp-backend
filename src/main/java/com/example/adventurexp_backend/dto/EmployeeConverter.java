package com.example.adventurexp_backend.dto;

import com.example.adventurexp_backend.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public Employee toEntity(EmployeeDTO employeeDTO){
        return new Employee(
                employeeDTO.id(),
                employeeDTO.email(),
                employeeDTO.password()
        );
    }

    public EmployeeDTO toDTO(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getEmail(),
                employee.getPassword()
        );
    }
}
