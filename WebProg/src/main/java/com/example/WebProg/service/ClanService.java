package com.example.WebProg.service;

import com.example.WebProg.model.Clan;
import com.example.WebProg.repository.ClanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClanService {

    @Autowired
    private ClanRepository clanRepository;

    public Boolean daLiPostoji(String korisnickoIme, String lozinka){
        Clan clan = this.clanRepository.findByKorisnickoIme(korisnickoIme);
        if(clan != null){
            if(clan.getLozinka().equals(lozinka)) return true;
        }
        return false;
    }
}
