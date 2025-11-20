package com.example.authentication.repos;

import com.example.authentication.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver, Long> {

}
