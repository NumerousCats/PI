package com.example.ride.service;

import com.example.ride.dto.CreateRideRequest;
import com.example.ride.entities.Ride;

import java.util.List;

public interface RideService {
    Ride createRide(CreateRideRequest request);
    void deleteRide(Long rideId, Long driverId);
    List<Ride> getRidesByDriver(Long driverId);
}
