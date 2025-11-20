package com.example.ride.entities;

import com.example.ride.enums.RideStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private City departureCity;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "destination_name")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "destination_postalcode"))
    })
    private City destinationCity;

    private LocalDate departureDate;
    private Integer availableSeats;
    private Double pricePerSeat;

    @Enumerated(EnumType.STRING)
    private RideStatus status = RideStatus.SCHEDULED;

    private Long driverId; // comes from Authentication MS

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;
}
