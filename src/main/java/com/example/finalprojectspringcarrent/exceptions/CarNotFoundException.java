package com.example.finalprojectspringcarrent.exceptions;

/**
 * @author Tiina Raudla
 * @Date
 */
public class CarNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public CarNotFoundException(Long id) {
        super(String.format("Car not found for id: %d", id));
    }
    public CarNotFoundException (String modelName) {
        super(String.format("Car not found for modelName: %s", modelName));
    }
}
