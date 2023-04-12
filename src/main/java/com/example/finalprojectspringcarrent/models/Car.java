package com.example.finalprojectspringcarrent.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Tiina Raudla
 * @Date
 */
@Data
@Entity
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String modelName;
    private String color;
    private String bodyType;
    private int yearOfProd;
    private int mileage;
    private int amount;
    private  boolean isBooked;

}
