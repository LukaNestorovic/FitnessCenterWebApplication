package com.example.WebProg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.WebProg.model.Termin;

public interface TerminRepository extends JpaRepository<Termin, Long> {
}
