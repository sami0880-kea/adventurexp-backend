package com.example.adventurexp_backend.dto;

import java.time.LocalTime;
import java.util.Date;

public record BookingDTO(int bookingid,
                         String name,
                         int participants,
                         String email,
                         int phoneNumber,
                         Date date,
                         LocalTime time,
                         String comment,
                         int activityId,
                         int total) {
}