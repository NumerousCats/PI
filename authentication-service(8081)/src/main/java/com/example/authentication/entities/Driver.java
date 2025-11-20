package com.example.authentication.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends AppUser {

    private String licenseNumber;
    private String vehicleNumber;
    private String vehiclePlate;
    private Boolean isVerified;
    private Double rating;
}
