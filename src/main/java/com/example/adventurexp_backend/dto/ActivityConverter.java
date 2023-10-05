package com.example.adventurexp_backend.dto;

import com.example.adventurexp_backend.model.Activity;
import org.springframework.stereotype.Component;

@Component
public class ActivityConverter {

    public Activity toEntity(ActivityDTO activityDTO) {
        return new Activity(
                activityDTO.id(),
                activityDTO.name(),
                activityDTO.image(),
                activityDTO.description(),
                activityDTO.minAge(),
                activityDTO.price()
        );
    }

    public ActivityDTO toDTO(Activity activity) {
        return new ActivityDTO(
                activity.getId(),
                activity.getName(),
                activity.getImage(),
                activity.getDescription(),
                activity.getMinAge(),
                activity.getPrice()
        );
    }
}
