package com.example.adventurexp_backend.controller;

import com.example.adventurexp_backend.model.Activity;
import com.example.adventurexp_backend.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ActivityController {
    @Autowired
    ActivityRepository activityRepository;

    @GetMapping(path = "/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping(path = "/activities")
    public ResponseEntity<List<Activity>> getActivities() {
        List<Activity> activities = activityRepository.findAll();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }
}
