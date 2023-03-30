package com.example.finalprojectspringcarrent.repositories;

import com.example.finalprojectspringcarrent.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Tiina Raudla
 * @Date
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findById(String name);
}
