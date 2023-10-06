package com.example.adventurexp_backend.controller;

import com.example.adventurexp_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService EmployeeService;

}
