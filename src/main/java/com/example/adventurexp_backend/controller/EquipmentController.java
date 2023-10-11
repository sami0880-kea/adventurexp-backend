package com.example.adventurexp_backend.controller;

import com.example.adventurexp_backend.dto.EquipmentDTO;
import com.example.adventurexp_backend.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;

    @GetMapping("/equipment/{activityId}")
    public ResponseEntity<List<EquipmentDTO>> getEquipmentByActivityId(@PathVariable("activityId") int activityId) {
        List<EquipmentDTO> equipmentDTOList = equipmentService.findAllEquipmentByActivityId(activityId);
        return new ResponseEntity<>(equipmentDTOList, HttpStatus.OK);
    }

    @DeleteMapping("/equipment/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable("id") int id) {
        equipmentService.deleteEquipmentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/equipment")
    public ResponseEntity<EquipmentDTO> postEquipment(@RequestBody EquipmentDTO equipmentDTO) {
        EquipmentDTO newEquipment = equipmentService.createEquipment(equipmentDTO);
        return new ResponseEntity<>(newEquipment, HttpStatus.CREATED);
    }

    @PutMapping("/equipment/{id}")
    public ResponseEntity<EquipmentDTO> putEquipment(@PathVariable("id") int id, @RequestBody EquipmentDTO equipmentDTO) {
        EquipmentDTO updatedEquipmentDTO = equipmentService.updateEquipment(id, equipmentDTO);
        return ResponseEntity.ok(updatedEquipmentDTO);
    }

}
