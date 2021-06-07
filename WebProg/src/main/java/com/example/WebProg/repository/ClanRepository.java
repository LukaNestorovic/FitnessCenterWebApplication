package com.example.WebProg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.WebProg.model.Clan;

public interface ClanRepository extends JpaRepository<Clan, Long> {
    Clan findByKorisnickoIme(String korisnickoIme);
}
