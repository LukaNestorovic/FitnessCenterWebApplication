package com.example.WebProg.controller;

import com.example.WebProg.model.Clan;
import com.example.WebProg.model.dto.ClanDTO;
import com.example.WebProg.service.RegistracijaClanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/registracijaclana")
public class RegistracijaClanaController {
    private final RegistracijaClanaService registracijaClanaService;

    @Autowired
    public RegistracijaClanaController(RegistracijaClanaService registracijaClanaService) {
        this.registracijaClanaService = registracijaClanaService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> createClan(@RequestBody ClanDTO clanDTO) throws Exception {
        Clan clan = new Clan(clanDTO.getKorisnicko_ime(), clanDTO.getLozinka(), clanDTO.getIme(), clanDTO.getPrezime(), clanDTO.getKontakt_telefon(), clanDTO.getEmail(), clanDTO.getDatum_rodjenja(), clanDTO.getUloga());

        Clan newClan = registracijaClanaService.create(clan);

        ClanDTO newClanDTO = new ClanDTO(newClan.getId(), newClan.getKorisnicko_ime(), newClan.getLozinka(), newClan.getIme(), newClan.getPrezime(), newClan.getKontakt_telefon(), newClan.getEmail(), newClan.getDatum_rodjenja(), newClan.getUloga());

        return new ResponseEntity<>(newClanDTO, HttpStatus.CREATED);
    }
}
