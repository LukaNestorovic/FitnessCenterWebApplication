package com.example.WebProg.controller;

import com.example.WebProg.model.*;
import com.example.WebProg.model.OdradjeniTrening;
import com.example.WebProg.model.dto.OdradjeniTreningDTO;
import com.example.WebProg.model.dto.OdradjeniTreningDTO;
import com.example.WebProg.model.dto.PrijavljeniTreningDTO;
import com.example.WebProg.model.dto.TreningDTO;
import com.example.WebProg.service.OdradjeniTreningService;
import com.example.WebProg.service.RegistracijaClanaService;
import com.example.WebProg.service.TerminService;
import com.example.WebProg.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/odradjeni-treninzi")
public class OdradjeniTreningController {
    private final OdradjeniTreningService odradjeniTreningService;
    private final RegistracijaClanaService clanService;
    private final TreningService treningService;
    private final TerminService terminService;

    @Autowired
    public OdradjeniTreningController(OdradjeniTreningService odradjeniTreningService, RegistracijaClanaService clanService, TreningService treningService, TerminService terminService) {
        this.odradjeniTreningService = odradjeniTreningService;
        this.clanService = clanService;
        this.treningService = treningService;
        this.terminService = terminService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OdradjeniTreningDTO> getOdradjeniTrening(@PathVariable("id") Long id) {
        OdradjeniTrening odradjeniTrening = this.odradjeniTreningService.findOne(id);

        OdradjeniTreningDTO odradjeniTreningDTO = new OdradjeniTreningDTO();
        odradjeniTreningDTO.setId(odradjeniTrening.getId());
        odradjeniTreningDTO.setOcena(odradjeniTrening.getOcena());
        odradjeniTreningDTO.setNaziv(odradjeniTrening.getTrening().getNaziv());
        odradjeniTreningDTO.setTip_treninga(odradjeniTrening.getTrening().getTip_treninga());
        odradjeniTreningDTO.setDatum_vreme(odradjeniTrening.getTermin().getDatum_vreme());

        return new ResponseEntity<>(odradjeniTreningDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/za-clana/{clanId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OdradjeniTreningDTO>> getOdradjeniTreningId(@PathVariable("clanId") Long clanId) {
        List<OdradjeniTrening> odradjeniTreningList = this.odradjeniTreningService.findByClanId(clanId);

        List<OdradjeniTreningDTO> odradjeniTreningDTOS = new ArrayList<>();

        for(OdradjeniTrening odradjeniTrening: odradjeniTreningList) {
            OdradjeniTreningDTO odradjeniTreningDTO = new OdradjeniTreningDTO(odradjeniTrening.getId(), odradjeniTrening.getOcena(), odradjeniTrening.getTrening().getNaziv(), odradjeniTrening.getTrening().getTip_treninga(), odradjeniTrening.getTermin().getDatum_vreme());
            odradjeniTreningDTOS.add(odradjeniTreningDTO);
        }

        return new ResponseEntity<>(odradjeniTreningDTOS, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OdradjeniTreningDTO> updateOdradjenihTreninga(@PathVariable Long id, @RequestBody OdradjeniTreningDTO odradjeniTreningDTO) throws Exception {
        OdradjeniTrening odradjeniTrening = new OdradjeniTrening(odradjeniTreningDTO.getOcena());
        odradjeniTrening.setId(id);

        OdradjeniTrening updatedOdradjeniTrening = odradjeniTreningService.update(odradjeniTrening);

        OdradjeniTreningDTO updatedOdradjeniTreningDTO = new OdradjeniTreningDTO(updatedOdradjeniTrening.getId(), updatedOdradjeniTrening.getOcena(), updatedOdradjeniTrening.getTrening().getNaziv(), updatedOdradjeniTrening.getTrening().getTip_treninga(), updatedOdradjeniTrening.getTermin().getDatum_vreme());

        return new ResponseEntity<>(updatedOdradjeniTreningDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/za-trening/{treningId}/termin/{terminId}/clana/{clanId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OdradjeniTreningDTO> createOdradjeniTrening(@PathVariable("clanId") Long clanId, @PathVariable("terminId") Long terminId, @PathVariable("treningId") Long treningId) throws Exception {
        Clan clan = clanService.findOne(clanId);
        Trening trening = treningService.findOne(treningId);
        Termin termin = terminService.findOne(terminId);

        OdradjeniTrening odradjeniTrening = new OdradjeniTrening();

        odradjeniTrening.setTrening(trening);
        odradjeniTrening.setClan(clan);
        odradjeniTrening.setTermin(termin);

        OdradjeniTrening newOdradjeniTrening = odradjeniTreningService.create(odradjeniTrening);

        OdradjeniTreningDTO newOdradjeniTreningDTO = new OdradjeniTreningDTO(newOdradjeniTrening.getId(), newOdradjeniTrening.getOcena(), newOdradjeniTrening.getTrening().getNaziv(), newOdradjeniTrening.getTrening().getTip_treninga(), newOdradjeniTrening.getTermin().getDatum_vreme());

        return new ResponseEntity<>(newOdradjeniTreningDTO, HttpStatus.CREATED);
    }
}
