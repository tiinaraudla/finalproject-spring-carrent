package com.example.finalprojectspringcarrent.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Tiina Raudla
 * @Date
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Booking extends AudiTable<String> implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String dateOfBooking;
    @OneToOne(cascade = CascadeType.MERGE)
    private List<User> specializedUser;
    @OneToOne(cascade = CascadeType.MERGE)
    private List<Car> specializedCar;
    public LocalDate dateFrom;
    public LocalDate dateTo;

    @OneToOne(cascade = CascadeType.MERGE)
    private List<Branch> specializedBranches;

    public String returnBranch;
    public int amount;
}
