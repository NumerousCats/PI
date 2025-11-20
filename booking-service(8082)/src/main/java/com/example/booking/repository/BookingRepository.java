package com.example.booking.repository;

import com.example.booking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByPassengerId(Long passengerId);
    List<Booking> findByRideId(Long rideId);
}
