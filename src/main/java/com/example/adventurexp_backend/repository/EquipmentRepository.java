package com.example.adventurexp_backend.repository;

import com.example.adventurexp_backend.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

}
