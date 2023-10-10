package com.example.adventurexp_backend.controller;

import com.example.adventurexp_backend.dto.BookingDTO;
import com.example.adventurexp_backend.dto.BookingDTO;
import com.example.adventurexp_backend.dto.EmployeeDTO;
import com.example.adventurexp_backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BookingController {
    @Autowired
    BookingService bookingService;


    @GetMapping ("/booking/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable("id") int id) {
        BookingDTO bookingDTO = bookingService.getBookingById(id);
        return ResponseEntity.ok(bookingDTO);
    }
    @GetMapping("/bookings")
    public ResponseEntity<List<BookingDTO>> getBookings() {
        List<BookingDTO> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
    @PutMapping("/booking/{id}")
    public ResponseEntity<BookingDTO> putBooking(@PathVariable("id")int id, @RequestBody BookingDTO bookingDTO){
        BookingDTO updatedBookingDTO = bookingService.updateBooking(id, bookingDTO);
        return ResponseEntity.ok(updatedBookingDTO);
    }

    @PostMapping("/booking")
    public ResponseEntity<BookingDTO> postEmployee(@RequestBody BookingDTO bookingDTO){
        BookingDTO createdBooking = bookingService.createBooking(bookingDTO);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    @DeleteMapping("/booking/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("id") int id) {
        bookingService.deleteBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

