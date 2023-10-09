package com.example.adventurexp_backend.dto;

import com.example.adventurexp_backend.model.Equipment;
import org.springframework.stereotype.Component;

@Component
public class EquipmentConverter {

    public Equipment toEntity(EquipmentDTO equipmentDTO){
        return new Equipment(
                equipmentDTO.id(),
                equipmentDTO.name(),
                equipmentDTO.status(),
                equipmentDTO.price(),
                equipmentDTO.activityId()
        );
    }

    public EquipmentDTO toDTO(Equipment equipment){
        return new EquipmentDTO(
                equipment.getId(),
                equipment.getName(),
                equipment.isStatus(),
                equipment.getPrice(),
                equipment.getActivityId()
        );
    }
}
