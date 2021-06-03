package com.example.WebProg.service;

import com.example.WebProg.model.Clan;
import com.example.WebProg.repository.ClanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistracijaClanaService {

    @Autowired
    private ClanRepository clanRepository;

    public Clan create(Clan clan) throws Exception {
        if (clan.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Clan newClan = this.clanRepository.save(clan);
        return newClan;
    }

}
