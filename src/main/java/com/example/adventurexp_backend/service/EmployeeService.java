package com.example.adventurexp_backend.service;
import com.example.adventurexp_backend.dto.EmployeeConverter;
import com.example.adventurexp_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeConverter employeeConverter;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeConverter employeeConverter, EmployeeRepository employeeRepository)
    {
        this.employeeConverter = employeeConverter;
        this.employeeRepository = employeeRepository;
    }





}

