package com.example.WebProg.controller;

import com.example.WebProg.model.Clan;
import com.example.WebProg.model.dto.ClanDTO;
import com.example.WebProg.service.RegistracijaClanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/registracijaclana")
public class RegistracijaClanaController {
    private final RegistracijaClanaService registracijaClanaService;

    @Autowired
    public RegistracijaClanaController(RegistracijaClanaService registracijaClanaService) {
        this.registracijaClanaService = registracijaClanaService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> getClan(@PathVariable("id") Long id) {
        Clan clan = this.registracijaClanaService.findOne(id);

        ClanDTO clanDTO = new ClanDTO();
        clanDTO.setId(clan.getId());
        clanDTO.setKorisnickoIme(clan.getkorisnickoIme());
        clanDTO.setLozinka(clan.getLozinka());
        clanDTO.setIme(clan.getIme());
        clanDTO.setPrezime(clan.getPrezime());
        clanDTO.setKontakt_telefon(clan.getKontakt_telefon());
        clanDTO.setEmail(clan.getEmail());
        clanDTO.setDatum_rodjenja(clan.getDatum_rodjenja());
        clanDTO.setUloga(clan.getUloga());

        return new ResponseEntity<>(clanDTO, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClanDTO>> getClan() {
        List<Clan> clanList = this.registracijaClanaService.findAll();

        List<ClanDTO> clanDTOS = new ArrayList<>();

        for(Clan clan: clanList) {
            ClanDTO clanDTO = new ClanDTO(clan.getId(), clan.getkorisnickoIme(), clan.getLozinka(), clan.getIme(), clan.getPrezime(), clan.getKontakt_telefon(), clan.getEmail(), clan.getDatum_rodjenja(), clan.getUloga());
            clanDTOS.add(clanDTO);
        }

        return new ResponseEntity<>(clanDTOS, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> createClan(@RequestBody ClanDTO clanDTO) throws Exception {
        Clan clan = new Clan(clanDTO.getKorisnickoIme(), clanDTO.getLozinka(), clanDTO.getIme(), clanDTO.getPrezime(), clanDTO.getKontakt_telefon(), clanDTO.getEmail(), clanDTO.getDatum_rodjenja(), clanDTO.getUloga());

        Clan newClan = registracijaClanaService.create(clan);

        ClanDTO newClanDTO = new ClanDTO(newClan.getId(), newClan.getkorisnickoIme(), newClan.getLozinka(), newClan.getIme(), newClan.getPrezime(), newClan.getKontakt_telefon(), newClan.getEmail(), newClan.getDatum_rodjenja(), newClan.getUloga());

        return new ResponseEntity<>(newClanDTO, HttpStatus.CREATED);
    }
}
