package com.example.WebProg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.WebProg.model.Termin;

import java.util.List;

public interface TerminRepository extends JpaRepository<Termin, Long> {
    List<Termin> findByTreningId(Long trening_id);
}
