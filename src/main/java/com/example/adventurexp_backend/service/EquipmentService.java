package com.example.adventurexp_backend.service;

import com.example.adventurexp_backend.dto.EquipmentConverter;
import com.example.adventurexp_backend.dto.EquipmentDTO;
import com.example.adventurexp_backend.exception.NotFoundException;
import com.example.adventurexp_backend.model.Equipment;
import com.example.adventurexp_backend.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            Equipment equipmentToUpdate = equipmentConverter.toEntity(equipmentDTO);
            equipmentToUpdate.setId(id);
            Equipment savedEquipment = equipmentRepository.save(equipmentToUpdate);
            return equipmentConverter.toDTO(savedEquipment);
        } else {
            throw new NotFoundException("Equipment not found with id: " +id);
        }
    }

    public List<EquipmentDTO> findAllEquipmentByActivityId(int activityId) {
        List<Equipment> equipment = equipmentRepository.findAllByActivityId(activityId);
        return equipment.stream()
                .map(equipmentConverter::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteEquipmentById(int id) {
        Optional<Equipment> equipment = equipmentRepository.findById(id);
        if(equipment.isPresent()) {
            equipmentRepository.deleteById(id);
        } else {
            throw new NotFoundException("Equipment not found with id:" +id);
        }
    }

    public EquipmentDTO createEquipment(EquipmentDTO equipmentDTO) {
        Equipment equipmentToSave = equipmentConverter.toEntity(equipmentDTO);
        equipmentToSave.setId(0);
        Equipment savedEquipment = equipmentRepository.save(equipmentToSave);
        return equipmentConverter.toDTO(savedEquipment);
    }


}
