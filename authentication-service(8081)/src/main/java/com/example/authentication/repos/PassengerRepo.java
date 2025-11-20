package com.example.authentication.repos;

import com.example.authentication.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepo extends JpaRepository<Passenger, Long> {}
