package com.example.WebProg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.WebProg.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
}
