package com.example.adventurexp_backend.service;
import com.example.adventurexp_backend.dto.ActivityConverter;
import com.example.adventurexp_backend.dto.ActivityDTO;
import com.example.adventurexp_backend.dto.EmployeeDTO;
import com.example.adventurexp_backend.exception.NotFoundException;
import com.example.adventurexp_backend.model.Activity;
import com.example.adventurexp_backend.model.Employee;
import com.example.adventurexp_backend.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ActivityService {
    private final ActivityConverter activityConverter;
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityConverter activityConverter, ActivityRepository activityRepository) {
        this.activityConverter = activityConverter;
        this.activityRepository = activityRepository;
    }


    public ActivityDTO getActivityById(int id) {
        Optional<Activity> activityOptional = activityRepository.findById(id);
        if (activityOptional.isPresent()) {
            Activity activity = activityOptional.get();
            return activityConverter.toDTO(activityOptional.get());
        } else {
            throw new NotFoundException("Activity not found with Id " + id);
        }
    }

    public ActivityDTO createActivity(ActivityDTO activityDTO){
        Activity activityToSave = activityConverter.toEntity(activityDTO);
        activityToSave.setId(0);
        Activity savedActivity = activityRepository.save(activityToSave);
        return activityConverter.toDTO(savedActivity);
    }

    public List<ActivityDTO> getAllActivities() {
        List<Activity> activities = activityRepository.findAll();
        return activities.stream()
                .map(activityConverter::toDTO)
                .collect(Collectors.toList());
    }

    public ActivityDTO updateActivity(int id, ActivityDTO activityDTO) {
        Optional<Activity> existingActivity = activityRepository.findById(id);
        if (existingActivity.isPresent()) {
            Activity activityToUpdate = activityConverter.toEntity(activityDTO);
            activityToUpdate.setId(id);
            Activity savedActivity = activityRepository.save(activityToUpdate);
            return activityConverter.toDTO(savedActivity);
        } else {
            throw new NotFoundException("Employee not found with id " + id);
        }
    }

    public void deleteActivity(int id) {
        Optional<Activity> activity = activityRepository.findById(id);
        if (activity.isPresent()) {
            activityRepository.deleteById(id);
        } else {
            throw new NotFoundException("Activity not found with id: " + id);
        }

    }
}
