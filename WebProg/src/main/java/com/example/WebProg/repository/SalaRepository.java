package com.example.WebProg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.WebProg.model.Sala;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    List<Sala> findByFitnes_centar_id(Long fitnesCentarId);
}
