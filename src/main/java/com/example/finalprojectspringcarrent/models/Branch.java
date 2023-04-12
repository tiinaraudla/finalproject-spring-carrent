package com.example.finalprojectspringcarrent.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Tiina Raudla
 * @Date
 */
@Data
@Entity
public class Branch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String address;   //address with the city

    @OneToMany(cascade = CascadeType.MERGE)
    public List<Car> specializedCars;

    private boolean isActive;
}
