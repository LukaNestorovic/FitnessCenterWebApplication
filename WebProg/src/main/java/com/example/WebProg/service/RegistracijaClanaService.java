package com.example.WebProg.service;

import com.example.WebProg.model.Clan;
import com.example.WebProg.model.Clan;
import com.example.WebProg.repository.RegistracijaClanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistracijaClanaService {

    @Autowired
    private RegistracijaClanaRepository registracijaClanaRepository;

    public Clan findOne(Long id) {
        Clan clan = this.registracijaClanaRepository.getOne(id);
        return clan;
    }

    public List<Clan> findAll() {
        List<Clan> clans = this.registracijaClanaRepository.findAll();
        return clans;
    }

    public Clan create(Clan clan) throws Exception {
        if (clan.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Clan newClan = this.registracijaClanaRepository.save(clan);
        return newClan;
    }

    public Clan update(Clan clan) throws Exception{
        Clan clanToUpdate = this.registracijaClanaRepository.getOne(clan.getId());
        if(clanToUpdate == null){
            throw new Exception("Clan ne postoji");
        }

        clanToUpdate.setkorisnickoIme(clan.getkorisnickoIme());
        clanToUpdate.setLozinka(clan.getLozinka());
        clanToUpdate.setIme(clan.getIme());
        clanToUpdate.setPrezime(clan.getPrezime());
        clanToUpdate.setKontakt_telefon(clan.getKontakt_telefon());
        clanToUpdate.setEmail(clan.getEmail());

        Clan savedClan = this.registracijaClanaRepository.save(clanToUpdate);
        return savedClan;
    }

}
