package com.example.adventurexp_backend.repository;

import com.example.adventurexp_backend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
