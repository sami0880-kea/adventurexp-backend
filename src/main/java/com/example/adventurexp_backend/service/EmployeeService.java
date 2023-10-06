package com.example.adventurexp_backend.service;
import com.example.adventurexp_backend.dto.EmployeeConverter;
import com.example.adventurexp_backend.dto.EmployeeDTO;
import com.example.adventurexp_backend.exception.EmployeeNotFoundException;
import com.example.adventurexp_backend.model.Employee;
import com.example.adventurexp_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeConverter employeeConverter;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeConverter employeeConverter, EmployeeRepository employeeRepository) {
        this.employeeConverter = employeeConverter;
        this.employeeRepository = employeeRepository;
    }


    public EmployeeDTO getEmployeeById(int id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            return employeeConverter.toDTO(employee);
        } else {
            throw new EmployeeNotFoundException("Employee not found with Id " + id);
        }
    }
}

