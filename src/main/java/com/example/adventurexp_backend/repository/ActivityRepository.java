package com.example.adventurexp_backend.repository;

import com.example.adventurexp_backend.model.Activity;
import com.example.adventurexp_backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository {
    List<Activity> findAllById(String id);

}
