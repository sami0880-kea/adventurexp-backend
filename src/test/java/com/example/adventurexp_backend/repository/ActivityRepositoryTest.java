package com.example.adventurexp_backend.repository;

import com.example.adventurexp_backend.model.Activity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
@SpringBootTest
class ActivityRepositoryTest {
    private ActivityRepository activityRepository;

    @BeforeEach
    void setUp() {
        activityRepository = new ActivityRepository();
    }

    @Test
    void viewActivities() {
        //act
        List<Activity> activities = activityRepository.viewActivities();
        //assert
        assertNotNull(activities);
        assertTrue(activities.size() > 0);

        }
}
