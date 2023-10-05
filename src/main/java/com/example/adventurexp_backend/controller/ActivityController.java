package com.example.adventurexp_backend.controller;

import com.example.adventurexp_backend.model.Activity;
import com.example.adventurexp_backend.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ActivityController {
    @Autowired
    ActivityService activityService;

    /*public ActivityController() {
        activityService = new ActivityService(activityConverter);
    }

    @GetMapping(path = "/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping(path = "/activities")
    public ResponseEntity<List<Activity>> getActivities() {
        List<Activity> activities = activityService.viewActivities();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }*/
}
