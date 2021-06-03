package com.example.WebProg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.WebProg.model.FitnesCentar;

import java.util.List;

public interface FitnesCentarRepository extends JpaRepository<FitnesCentar, Long> {

    List<FitnesCentar> findAllById(Long id);

}
