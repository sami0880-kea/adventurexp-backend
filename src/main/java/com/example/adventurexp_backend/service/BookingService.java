package com.example.adventurexp_backend.service;


import com.example.adventurexp_backend.dto.BookingDTO;
import com.example.adventurexp_backend.dto.BookingConverter;
import com.example.adventurexp_backend.dto.BookingDTO;
import com.example.adventurexp_backend.dto.EmployeeDTO;
import com.example.adventurexp_backend.exception.NotFoundException;
import com.example.adventurexp_backend.model.Booking;
import com.example.adventurexp_backend.model.Booking;
import com.example.adventurexp_backend.model.Employee;
import com.example.adventurexp_backend.repository.ActivityRepository;
import com.example.adventurexp_backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public BookingDTO getBookingById(int id) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            return bookingConverter.toDTO(bookingOptional.get());
        } else {
            throw new NotFoundException("Booking not found with Id " + id);
        }
    }
        public BookingDTO updateBooking(int id, BookingDTO bookingDTO) {
            Optional<Booking> existingBooking = bookingRepository.findById(id);
            if (existingBooking.isPresent()) {
                Booking bookingToUpdate = bookingConverter.toEntity(bookingDTO);
                bookingToUpdate.setBookingId(id);
                Booking savedBooking = bookingRepository.save(bookingToUpdate);
                return bookingConverter.toDTO(savedBooking);
            } else {
                throw new NotFoundException("Booking not found with id " + id);
            }
        }
    public BookingDTO createBooking(BookingDTO bookingDTO){
        Booking bookingToSave = bookingConverter.toEntity(bookingDTO);
        bookingToSave.setBookingId(0);
        Booking savedEmployee = bookingRepository.save(bookingToSave);
        return bookingConverter.toDTO(savedEmployee);
    }

        public void deleteBooking(int id) {
            Optional<Booking> booking = bookingRepository.findById(id);
            if (booking.isPresent()) {
                bookingRepository.deleteById(id);
            } else {
                throw new NotFoundException("Booking not found with id: " + id);
            }

        }

}
