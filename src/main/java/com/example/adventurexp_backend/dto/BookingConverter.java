package com.example.adventurexp_backend.dto;

import com.example.adventurexp_backend.model.Booking;
import com.example.adventurexp_backend.model.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;

@Component
public class BookingConverter {

    public Booking toEntity(BookingDTO bookingDTO) {
        return new Booking(
                bookingDTO.bookingid(),
                bookingDTO.name(),
                bookingDTO.participants(),
                bookingDTO.email(),
                bookingDTO.phoneNumber(),
                bookingDTO.date(),
                bookingDTO.time(),
                bookingDTO.comment(),
                bookingDTO.activityId(),
                bookingDTO.total()
        );
    }

    public BookingDTO toDTO(Booking booking) {
        return new BookingDTO(
                booking.getBookingId(),
                booking.getName(),
                booking.getParticipants(),
                booking.getEmail(),
                booking.getPhoneNumber(),
                booking.getDate(),
                booking.getTime(),
                booking.getComment(),
                booking.getActivityId(),
                booking.getTotal()
        );
    }
}