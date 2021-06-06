package com.example.WebProg.controller;

import com.example.WebProg.model.Trener;
import com.example.WebProg.model.dto.TrenerDTO;
import com.example.WebProg.service.RegistracijaTreneraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/registracijatrenera")
public class RegistracijaTreneraController {
    private final RegistracijaTreneraService registracijaTreneraService;

    @Autowired
    public RegistracijaTreneraController(RegistracijaTreneraService registracijaTreneraService) {
        this.registracijaTreneraService = registracijaTreneraService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> getTrener(@PathVariable("id") Long id) {
        Trener trener = this.registracijaTreneraService.findOne(id);

        TrenerDTO trenerDTO = new TrenerDTO();
        trenerDTO.setId(trener.getId());
        trenerDTO.setKorisnicko_ime(trener.getKorisnicko_ime());
        trenerDTO.setLozinka(trener.getLozinka());
        trenerDTO.setIme(trener.getIme());
        trenerDTO.setPrezime(trener.getPrezime());
        trenerDTO.setKontakt_telefon(trener.getKontakt_telefon());
        trenerDTO.setEmail(trener.getEmail());
        trenerDTO.setDatum_rodjenja(trener.getDatum_rodjenja());
        trenerDTO.setUloga(trener.getUloga());

        return new ResponseEntity<>(trenerDTO, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrenerDTO>> getTrener() {
        List<Trener> trenerList = this.registracijaTreneraService.findAll();

        List<TrenerDTO> trenerDTOS = new ArrayList<>();

        for(Trener trener: trenerList) {
            TrenerDTO trenerDTO = new TrenerDTO(trener.getId(), trener.getKorisnicko_ime(), trener.getLozinka(), trener.getIme(), trener.getPrezime(), trener.getKontakt_telefon(), trener.getEmail(), trener.getDatum_rodjenja(), trener.getUloga());
            trenerDTOS.add(trenerDTO);
        }

        return new ResponseEntity<>(trenerDTOS, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> createClan(@RequestBody TrenerDTO trenerDTO) throws Exception {
        Trener trener = new Trener(trenerDTO.getKorisnicko_ime(), trenerDTO.getLozinka(), trenerDTO.getIme(), trenerDTO.getPrezime(), trenerDTO.getKontakt_telefon(), trenerDTO.getEmail(), trenerDTO.getDatum_rodjenja(), trenerDTO.getUloga());

        Trener newTrener = registracijaTreneraService.create(trener);

        TrenerDTO newTrenerDTO = new TrenerDTO(newTrener.getId(), newTrener.getKorisnicko_ime(), newTrener.getLozinka(), newTrener.getIme(), newTrener.getPrezime(), newTrener.getKontakt_telefon(), newTrener.getEmail(), newTrener.getDatum_rodjenja(), newTrener.getUloga());

        return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
    }
}
