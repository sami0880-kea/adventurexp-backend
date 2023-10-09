package com.example.adventurexp_backend.dto;

import com.example.adventurexp_backend.model.Equipment;

public class EquipmentConverter {

    public Equipment toEntity(EquipmentDTO equipmentDTO){
        return new Equipment(
                equipmentDTO.id(),
                equipmentDTO.name(),
                equipmentDTO.availableAmount(),
                equipmentDTO.bookedAmount(),
                equipmentDTO.price(),
                equipmentDTO.activityId()
        );
    }

    public EquipmentDTO toDTO(Equipment equipment){
        return new EquipmentDTO(
                equipment.getId(),
                equipment.getName(),
                equipment.getAvailableAmount(),
                equipment.getBookedAmount(),
                equipment.getPrice(),
                equipment.getActivityId()
        );
    }
}
