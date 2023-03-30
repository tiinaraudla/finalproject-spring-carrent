package com.example.finalprojectspringcarrent.controllers;

import com.example.finalprojectspringcarrent.models.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tiina Raudla
 * @Date
 */
@RestController
@RequestMapping("/api/cars")
public class CarController {
    private List<Car> cars = new ArrayList<>();
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(cars);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Car car = findCarById(id);
        if (car != null) {
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        car.setId((long) (cars.size() + 1));
        cars.add(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carUpdates) {
        Car car = findCarById(id);
        if (car != null) {
            car.setModelName(carUpdates.getModelName());
            car.setColor(carUpdates.getColor());
            car.setBodyType(carUpdates.getBodyType());
            car.setYearOfProd(carUpdates.getYearOfProd());
            car.setMileage(carUpdates.getMileage());
            car.setAmount(carUpdates.getAmount());
            car.setBooked(carUpdates.isBooked());
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        Car car = findCarById(id);
        if (car != null) {
            cars.remove(car);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    private Car findCarById(Long id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }
}
