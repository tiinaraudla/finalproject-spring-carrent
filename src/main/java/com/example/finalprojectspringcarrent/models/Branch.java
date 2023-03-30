package com.example.finalprojectspringcarrent.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author Tiina Raudla
 * @Date
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Branch extends AudiTable<String> implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String address;   //address with the city
    @ManyToOne(cascade = CascadeType.MERGE)
    private List<User> specializedUser;
    @ManyToOne(cascade = CascadeType.MERGE)
    private List<Car> specializedCar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<User> getSpecializedUser() {
        return specializedUser;
    }

    public void setSpecializedUser(List<User> specializedUser) {
        this.specializedUser = specializedUser;
    }

    public List<Car> getSpecializedCar() {
        return specializedCar;
    }

    public void setSpecializedCar(List<Car> specializedCar) {
        this.specializedCar = specializedCar;
    }

    public Branch(Long id, String address, List<User> specializedUser, List<Car> specializedCar) {
        this.id = id;
        this.address = address;
        this.specializedUser = specializedUser;
        this.specializedCar = specializedCar;
    }
}
