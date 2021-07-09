package com.example.WebProg.repository;

import com.example.WebProg.model.PrijavljeniTrening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrijavljeniTreningRepository extends JpaRepository<PrijavljeniTrening, Long> {
    List<PrijavljeniTrening> findByTerminId(Long termin_id);
}
