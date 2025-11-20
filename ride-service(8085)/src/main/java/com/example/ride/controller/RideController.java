package com.example.ride.controller;

import com.example.ride.dto.CreateRideRequest;
import com.example.ride.entities.Ride;
import com.example.ride.service.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
@RequiredArgsConstructor
public class RideController {

    private final RideService rideService;

    @PostMapping("/create")
    public Ride publishRide(@RequestBody CreateRideRequest request) {
        return rideService.createRide(request);
    }

    @DeleteMapping("/{rideId}")
    public String deleteRide(@PathVariable Long rideId, @RequestParam Long driverId) {
        rideService.deleteRide(rideId, driverId);
        return "Ride deleted successfully";
    }

    @GetMapping("/driver/{driverId}")
    public List<Ride> getDriverRides(@PathVariable Long driverId) {
        return rideService.getRidesByDriver(driverId);
    }
}
