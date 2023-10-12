package com.example.adventurexp_backend.service;
import com.example.adventurexp_backend.dto.EmployeeConverter;
import com.example.adventurexp_backend.dto.EmployeeDTO;
import com.example.adventurexp_backend.exception.NotFoundException;
import com.example.adventurexp_backend.model.Employee;
import com.example.adventurexp_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
            return employeeConverter.toDTO(employeeOptional.get());
        } else {
            throw new NotFoundException("Employee not found with Id " + id);
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
            throw new NotFoundException("Employee not found with id " + id);
        }
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
        Employee employeeToSave = employeeConverter.toEntity(employeeDTO);
        employeeToSave.setId(0);
        Employee savedEmployee = employeeRepository.save(employeeToSave);
        return employeeConverter.toDTO(savedEmployee);
    }

    public void deleteEmployee(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            employeeRepository.deleteById(id);
        } else {
            throw new NotFoundException("Employee not found with id: " + id);
        }
    }

    public boolean verifyLogin(String email, String password) {
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(email);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            if(Objects.equals(employee.getPassword(), password)) {
                return true;
            } else {
                return false;
            }
        }
        return false;

    }

}

