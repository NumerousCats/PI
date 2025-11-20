package com.example.ride.service;

import com.example.ride.dto.CreateRideRequest;
import com.example.ride.entities.Ride;
import com.example.ride.repository.RideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;

    @Override
    public Ride createRide(CreateRideRequest request) {
        Ride ride = new Ride();
        ride.setDepartureCity(request.getDepartureCity());
        ride.setDestinationCity(request.getDestinationCity());
        ride.setDepartureDate(request.getDepartureDate());
        ride.setAvailableSeats(request.getAvailableSeats());
        ride.setPricePerSeat(request.getPricePerSeat());
        ride.setDriverId(request.getDriverId());

        return rideRepository.save(ride);
    }

    @Override
    public void deleteRide(Long rideId, Long driverId) {
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride not found"));

        if (!ride.getDriverId().equals(driverId)) {
            throw new RuntimeException("You cannot delete someone else's ride");
        }

        rideRepository.delete(ride);
    }

    @Override
    public List<Ride> getRidesByDriver(Long driverId) {
        return rideRepository.findByDriverId(driverId);
    }
}
