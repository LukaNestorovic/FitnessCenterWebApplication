package com.example.WebProg.service;

import com.example.WebProg.model.Clan;
import com.example.WebProg.repository.ClanRepository;
import com.example.WebProg.repository.RegistracijaClanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogInClanaService {
    @Autowired
    private RegistracijaClanaRepository registracijaClanaRepository;
    private ClanRepository clanRepository;

    public Clan findOne(Long id) {
        Clan clan = this.registracijaClanaRepository.getOne(id);
        return clan;
    }

    public List<Clan> findAll() {
        List<Clan> clans = this.registracijaClanaRepository.findAll();
        return clans;
    }
}
