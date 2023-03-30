package com.example.finalprojectspringcarrent.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Tiina Raudla
 * @Date
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Car extends AudiTable<String> implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String dateOfBooking;

    public String modelName;
    public String color;
    public String bodyType;
    public int yearOfProd;
    public int mileage;

    @OneToOne(cascade = CascadeType.MERGE)
    public Car car;
    public LocalDate dateFrom;
    public LocalDate dateTo;

    @OneToOne(cascade = CascadeType.MERGE)
    public Branch branch;

    public String returnBranch;
    public int amount;
    public boolean booked;

    public Car(Long id, String dateOfBooking, String modelName, String color, String bodyType, int yearOfProd,
               int mileage, Car car, LocalDate dateFrom, LocalDate dateTo, Branch branch, String returnBranch,
               int amount, boolean booked) {
        this.id = id;
        this.dateOfBooking = dateOfBooking;
        this.modelName = modelName;
        this.color = color;
        this.bodyType = bodyType;
        this.yearOfProd = yearOfProd;
        this.mileage = mileage;
        this.car = car;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.branch = branch;
        this.returnBranch = returnBranch;
        this.amount = amount;
        this.booked = booked;
    }

}
