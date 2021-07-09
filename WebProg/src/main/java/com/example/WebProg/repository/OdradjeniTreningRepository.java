package com.example.WebProg.repository;

import com.example.WebProg.model.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.WebProg.model.OdradjeniTrening;

import java.util.List;

public interface OdradjeniTreningRepository extends JpaRepository<OdradjeniTrening, Long> {
    List<OdradjeniTrening> findByClanId(Long clan_id);
}
