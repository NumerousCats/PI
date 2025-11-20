package com.example.booking.controller;

import com.example.booking.dto.CreateBookingRequest;
import com.example.booking.dto.BookingResponse;
import com.example.booking.entities.Booking;
import com.example.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/create")
    public BookingResponse createBooking(@RequestBody CreateBookingRequest request) {
        return bookingService.bookRide(request);
    }

    @DeleteMapping("/{bookingId}")
    public String cancelBooking(
            @PathVariable Long bookingId,
            @RequestParam Long passengerId) {

        bookingService.cancelBooking(bookingId, passengerId);
        return "Booking canceled";
    }

    @GetMapping("/passenger/{passengerId}")
    public List<Booking> getPassengerBookings(@PathVariable Long passengerId) {
        return bookingService.getBookingsByPassenger(passengerId);
    }

    @GetMapping("/ride/{rideId}")
    public List<Booking> getRideBookings(@PathVariable Long rideId) {
        return bookingService.getBookingsByRide(rideId);
    }
}
