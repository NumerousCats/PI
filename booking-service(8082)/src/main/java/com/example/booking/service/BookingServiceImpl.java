package com.example.booking.service;

import com.example.booking.dto.CreateBookingRequest;
import com.example.booking.dto.BookingResponse;
import com.example.booking.entities.Booking;
import com.example.booking.enums.BookingStatus;
import com.example.booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public BookingResponse bookRide(CreateBookingRequest request) {

        Booking booking = new Booking();
        booking.setRideId(request.getRideId());
        booking.setPassengerId(request.getPassengerId());
        booking.setSeatsBooked(request.getSeats());
        booking.setStatus(BookingStatus.CONFIRMED);

        Booking saved = bookingRepository.save(booking);

        BookingResponse response = new BookingResponse();
        response.setBookingId(saved.getId());
        response.setRideId(saved.getRideId());
        response.setPassengerId(saved.getPassengerId());
        response.setSeatsBooked(saved.getSeatsBooked());
        response.setStatus(saved.getStatus());

        return response;
    }

    @Override
    public void cancelBooking(Long bookingId, Long passengerId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (!booking.getPassengerId().equals(passengerId)) {
            throw new RuntimeException("You cannot cancel another user's booking");
        }

        booking.setStatus(BookingStatus.CANCELED);
        booking.setUpdatedAt(LocalDateTime.now());

        bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByPassenger(Long passengerId) {
        return bookingRepository.findByPassengerId(passengerId);
    }

    @Override
    public List<Booking> getBookingsByRide(Long rideId) {
        return bookingRepository.findByRideId(rideId);
    }
}
