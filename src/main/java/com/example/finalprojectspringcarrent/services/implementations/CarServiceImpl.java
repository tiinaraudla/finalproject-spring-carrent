package com.example.finalprojectspringcarrent.services.implementations;

import com.example.finalprojectspringcarrent.exceptions.CarNotFoundException;
import com.example.finalprojectspringcarrent.models.Car;
import com.example.finalprojectspringcarrent.repositories.CarRepository;
import com.example.finalprojectspringcarrent.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        car.setBooked(true);
        carRepository.save(car);

    }

    @Override
    public Car findCarByModelName(String modelName) throws CarNotFoundException {
        Optional<Car> carOptional = carRepository.findCarByModelName(modelName);

        if(carOptional.isEmpty()) {
            throw new CarNotFoundException(modelName);
        }
        return carOptional.get();
    }

    @Override
    public Car findCarById(Long id) throws CarNotFoundException {
        Optional<Car> carOptional = carRepository.findById(id);

        if(carOptional.isEmpty()) {
            throw new CarNotFoundException(id);
        }
        return carOptional.get();
    }

    @Override
    public void updateCar(Car car) throws CarNotFoundException {
        if(findCarById(car.getId()) != null) {
            carRepository.saveAndFlush(car);
        }

    }
    @Override
    public List<Car> findAllCars() {

        return carRepository.findAll();
    }

    @Override
    public void deleteCarById(Long id) throws CarNotFoundException {
        Car car = findCarById(id);
        car.setBooked(false);
        carRepository.saveAndFlush(car);

    }

    @Override
    public void restoreCarById(Long id) throws CarNotFoundException {
        Car car = findCarById(id);
        car.setBooked(true);
        carRepository.saveAndFlush(car);

    }
}
