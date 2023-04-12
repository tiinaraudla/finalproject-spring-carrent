package com.example.finalprojectspringcarrent.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

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
    public Car car;
    public LocalDate dateFrom;
    public LocalDate dateTo;

    @OneToOne(cascade = CascadeType.MERGE)
    public Branch branch;

    public String returnBranch;
    public int amount;
}
