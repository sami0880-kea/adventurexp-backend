package com.example.adventurexp_backend.dto;

import java.time.LocalTime;
import java.util.Date;

public record BookingDTO(int bookingid,
                         String name,
                         int participants,
                         String email,
                         int phoneNumber,
                         LocalTime date,
                         Date time,
                         String comment,
                         int activityId,
                         int total) {
}