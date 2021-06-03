package com.example.WebProg.controller;

import com.example.WebProg.model.Clan;
import com.example.WebProg.model.Trener;
import com.example.WebProg.model.dto.ClanDTO;
import com.example.WebProg.model.dto.TrenerDTO;
import com.example.WebProg.service.RegistracijaClanaService;
import com.example.WebProg.service.RegistracijaTreneraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/registracijatrenera")
public class RegistracijaTreneraController {
    private final RegistracijaTreneraService registracijaTreneraService;

    @Autowired
    public RegistracijaTreneraController(RegistracijaTreneraService registracijaTreneraService) {
        this.registracijaTreneraService = registracijaTreneraService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> createClan(@RequestBody TrenerDTO trenerDTO) throws Exception {
        Trener trener = new Trener(trenerDTO.getKorisnicko_ime(), trenerDTO.getLozinka(), trenerDTO.getIme(), trenerDTO.getPrezime(), trenerDTO.getKontakt_telefon(), trenerDTO.getEmail(), trenerDTO.getDatum_rodjenja(), trenerDTO.getUloga());

        Trener newTrener = registracijaTreneraService.create(trener);

        TrenerDTO newTrenerDTO = new TrenerDTO(newTrener.getId(), newTrener.getKorisnicko_ime(), newTrener.getLozinka(), newTrener.getIme(), newTrener.getPrezime(), newTrener.getKontakt_telefon(), newTrener.getEmail(), newTrener.getDatum_rodjenja(), newTrener.getUloga());

        return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
    }
}
