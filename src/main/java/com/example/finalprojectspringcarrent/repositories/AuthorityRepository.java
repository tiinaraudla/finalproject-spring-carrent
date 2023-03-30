package com.example.finalprojectspringcarrent.repositories;

import com.example.finalprojectspringcarrent.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Tiina Raudla
 * @Date
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Optional<Authority> findByName(String name);
}
