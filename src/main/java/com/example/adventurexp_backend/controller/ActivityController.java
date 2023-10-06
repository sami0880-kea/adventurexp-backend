package com.example.adventurexp_backend.controller;

import com.example.adventurexp_backend.dto.ActivityDTO;
import com.example.adventurexp_backend.service.ActivityService;
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

    @GetMapping(path = "/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping(path = "/activities")
    public ResponseEntity<List<ActivityDTO>> getActivities() {
        List<ActivityDTO> activities = activityService.getAllActivities();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }
}
