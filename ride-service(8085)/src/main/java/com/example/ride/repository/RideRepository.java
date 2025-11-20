package com.example.ride.repository;

import com.example.ride.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByDriverId(Long driverId);
}
