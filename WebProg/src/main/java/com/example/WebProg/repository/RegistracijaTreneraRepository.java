package com.example.WebProg.repository;

import com.example.WebProg.model.Trener;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistracijaTreneraRepository extends JpaRepository<Trener, Long> {
}
