package com.example.adventurexp_backend.service;

import com.example.adventurexp_backend.dto.EquipmentConverter;
import com.example.adventurexp_backend.dto.EquipmentDTO;
import com.example.adventurexp_backend.exception.NotFoundException;
import com.example.adventurexp_backend.model.Equipment;
import com.example.adventurexp_backend.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentConverter equipmentConverter;

    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository, EquipmentConverter equipmentConverter)
    {
        this.equipmentRepository = equipmentRepository;
        this.equipmentConverter = equipmentConverter;
    }

    public EquipmentDTO updateEquipment(int id, EquipmentDTO equipmentDTO) {
        Optional<Equipment> existingEquipment = equipmentRepository.findById(id);
        if(existingEquipment.isPresent()) {
            Equipment equipmentToupdate = equipmentConverter.toEntity(equipmentDTO);
            equipmentToupdate.setId(id);
            Equipment savedEquipment = equipmentRepository.save(equipmentToupdate);
            return equipmentConverter.toDTO(savedEquipment);
        } else {
            throw new NotFoundException("Equipment not found with id: " +id);
        }
    }

}
