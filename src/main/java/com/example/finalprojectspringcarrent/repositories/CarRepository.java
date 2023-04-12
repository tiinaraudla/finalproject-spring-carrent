package com.example.finalprojectspringcarrent.repositories;

import com.example.finalprojectspringcarrent.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Tiina Raudla
 * @Date
 */
public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findCarByModelName(String modelName);
}
