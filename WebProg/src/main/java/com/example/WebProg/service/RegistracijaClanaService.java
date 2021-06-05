package com.example.WebProg.service;

import com.example.WebProg.model.Clan;
import com.example.WebProg.model.Clan;
import com.example.WebProg.repository.ClanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistracijaClanaService {

    @Autowired
    private ClanRepository clanRepository;

    public Clan findOne(Long id) {
        Clan clan = this.clanRepository.getOne(id);
        return clan;
    }

    public List<Clan> findAll() {
        List<Clan> clans = this.clanRepository.findAll();
        return clans;
    }

    public Clan create(Clan clan) throws Exception {
        if (clan.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Clan newClan = this.clanRepository.save(clan);
        return newClan;
    }

}
