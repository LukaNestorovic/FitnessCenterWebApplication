package com.example.WebProg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.WebProg.model.Trening;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening, Long> {

    List<Trening> findAllById(Long id);

}
