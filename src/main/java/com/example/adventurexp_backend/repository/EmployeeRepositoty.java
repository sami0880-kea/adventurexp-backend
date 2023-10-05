package com.example.adventurexp_backend.repository;

import com.example.adventurexp_backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepositoty extends JpaRepository {

    List<Employee> findAllByName(String name);

}
