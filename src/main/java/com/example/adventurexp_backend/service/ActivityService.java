package com.example.adventurexp_backend.service;
import com.example.adventurexp_backend.dto.ActivityConverter;
import com.example.adventurexp_backend.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ActivityService {
    private final ActivityConverter activityConverter;
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityConverter activityConverter, ActivityRepository activityRepository)
    {
        this.activityConverter = activityConverter;
        this.activityRepository = activityRepository;
    }


}
