package com.example.adventurexp_backend.controller;

import com.example.adventurexp_backend.dto.ActivityDTO;
import com.example.adventurexp_backend.dto.EmployeeDTO;
import com.example.adventurexp_backend.service.ActivityService;
import com.example.adventurexp_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @GetMapping ("/activity/{id}")
    public ResponseEntity<ActivityDTO> getActivityById(@PathVariable("id") int id) {
        ActivityDTO activityDTO = activityService.getActivityById(id);
        return ResponseEntity.ok(activityDTO);
    }

    @GetMapping("/activity")
    public ResponseEntity<List<ActivityDTO>> getAllActivity(){
        List<ActivityDTO> activityDTOList = activityService.getAllActivities();
        return new ResponseEntity<>(activityDTOList, HttpStatus.OK);
    }

    @PutMapping("/activity/{id}")
    public ResponseEntity<ActivityDTO> putActivity(@PathVariable("id")int id, @RequestBody ActivityDTO activityDTO){
        ActivityDTO updatedActivityDTO = activityService.updateActivity(id, activityDTO);
        return ResponseEntity.ok(updatedActivityDTO);
    }

    @DeleteMapping("/activity/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable("id") int id) {
        activityService.deleteActivity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
