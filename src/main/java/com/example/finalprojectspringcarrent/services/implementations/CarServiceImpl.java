package com.example.finalprojectspringcarrent.services.implementations;

import com.example.finalprojectspringcarrent.exceptions.CarNotFoundException;
import com.example.finalprojectspringcarrent.models.Branch;
import com.example.finalprojectspringcarrent.models.Car;
import com.example.finalprojectspringcarrent.repositories.CarRepository;
import com.example.finalprojectspringcarrent.services.CarService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tiina Raudla
 * @Date
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Override
    public void addCar(Car car) {

    }

    @Override
    public Car findCarById(Long id) throws CarNotFoundException {
        return null;
    }

    @Override
    public Car findCarByModelName(String name) throws CarNotFoundException {
        return null;
    }

    @Override
    public List<Car> findAllCars() {
        return null;
    }

    @Override
    public List<Car> findAllCarsByBranches(Branch branch) {
        return null;
    }

    @Override
    public void updateCar(Car car) throws CarNotFoundException {

    }

    @Override
    public void deleteCarById(Long id) throws CarNotFoundException {

    }

    @Override
    public void restoreCarById(Long id) throws CarNotFoundException {

    }
}
