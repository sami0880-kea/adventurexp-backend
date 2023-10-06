package com.example.adventurexp_backend.service;


import com.example.adventurexp_backend.dto.ActivityDTO;
import com.example.adventurexp_backend.dto.BookingConverter;
import com.example.adventurexp_backend.dto.BookingDTO;
import com.example.adventurexp_backend.model.Activity;
import com.example.adventurexp_backend.model.Booking;
import com.example.adventurexp_backend.repository.ActivityRepository;
import com.example.adventurexp_backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final BookingConverter bookingConverter;
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingConverter bookingConverter, BookingRepository bookingRepository)
    {
        this.bookingConverter = bookingConverter;
        this.bookingRepository = bookingRepository;
    }

    public List<BookingDTO> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map(bookingConverter::toDTO)
                .collect(Collectors.toList());
    }


}
