package com.example.adventurexp_backend.service;
import com.example.adventurexp_backend.dto.EmployeeConverter;
import com.example.adventurexp_backend.dto.EmployeeDTO;
import com.example.adventurexp_backend.exception.EmployeeNotFoundException;
import com.example.adventurexp_backend.model.Employee;
import com.example.adventurexp_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            return employeeConverter.toDTO(employeeOptional.get());
        } else {
            throw new EmployeeNotFoundException("Employee not found with Id " + id);
        }
    }

    public List<EmployeeDTO> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employeeConverter::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO){
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()){
            Employee employeeToUpdate = employeeConverter.toEntity(employeeDTO);
            employeeToUpdate.setId(id);
            Employee savedEmployee = employeeRepository.save(employeeToUpdate);
            return employeeConverter.toDTO(savedEmployee);
        } else {
            throw new EmployeeNotFoundException("Employee not found with id " + id);
        }
    }
}

