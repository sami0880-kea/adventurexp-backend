package com.example.adventurexp_backend.repository;

import com.example.adventurexp_backend.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
    List<Equipment> findAllByActivityId(int activityId);
}
