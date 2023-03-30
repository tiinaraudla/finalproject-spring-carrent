package com.example.finalprojectspringcarrent.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Auditable;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Tiina Raudla
 * @Date
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Rental extends AudiTable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public LocalDate dateOfReturn;
    @OneToOne(cascade = CascadeType.MERGE)
    private Booking booking;
    public String comments;

    public boolean isActive;
}
