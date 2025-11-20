package com.example.booking.dto;

import lombok.Data;

@Data
public class CreateBookingRequest {
    private Long rideId;
    private Long passengerId;
    private Integer seats = 1; // optional
}
