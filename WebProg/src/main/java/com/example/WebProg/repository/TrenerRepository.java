package com.example.WebProg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.WebProg.model.Trener;

public interface TrenerRepository extends JpaRepository<Trener, Long> {
    Trener findByKorisnicko_ime(String korisnicko_ime);
}
