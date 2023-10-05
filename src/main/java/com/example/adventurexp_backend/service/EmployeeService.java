package com.example.adventurexp_backend.service;
import com.example.adventurexp_backend.dto.EmployeeConverter;
import com.example.adventurexp_backend.repository.DBConnector;
import com.example.adventurexp_backend.repository.EmployeeRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeConverter employeeConverter;
    private final EmployeeRepositoty employeeRepositoty;
    DBConnector connector;

    @Autowired
    public EmployeeService(EmployeeConverter employeeConverter, EmployeeRepositoty employeeRepositoty, DBConnector connector)
    {
        this.employeeConverter = employeeConverter;
        this.employeeRepositoty = employeeRepositoty;
        this.connector = connector;
    }





}

