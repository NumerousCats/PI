package com.example.booking.dto;

import com.example.booking.enums.BookingStatus;
import lombok.Data;

@Data
public class BookingResponse {
    private Long bookingId;
    private Long rideId;
    private Long passengerId;
    private Integer seatsBooked;
    private BookingStatus status;
}
