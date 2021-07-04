package com.example.WebProg.controller;

import com.example.WebProg.model.OdradjeniTrening;
import com.example.WebProg.model.Trening;
import com.example.WebProg.model.dto.OdradjeniTreningDTO;
import com.example.WebProg.model.dto.TreningDTO;
import com.example.WebProg.service.OdradjeniTreningService;
import com.example.WebProg.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/odradjeni-treninzi")
public class OdradjeniTreningController {
    private final OdradjeniTreningService odradjeniTreningService;

    @Autowired
    public OdradjeniTreningController(OdradjeniTreningService odradjeniTreningService) {
        this.odradjeniTreningService = odradjeniTreningService;
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OdradjeniTreningDTO>> getOdradjeniTrening() {
        List<OdradjeniTrening> odradjeniTreningList = this.odradjeniTreningService.findAll();

        List<OdradjeniTreningDTO> odradjeniTreningDTOS = new ArrayList<>();

        for(OdradjeniTrening odradjeniTrening: odradjeniTreningList) {
            OdradjeniTreningDTO odradjeniTreningDTO = new OdradjeniTreningDTO(odradjeniTrening.getId(), odradjeniTrening.getOcena(), odradjeniTrening.getTrening().getNaziv(), odradjeniTrening.getTrening().getTip_treninga(), odradjeniTrening.getTermin().getDatum_vreme());
            odradjeniTreningDTOS.add(odradjeniTreningDTO);
        }

        return new ResponseEntity<>(odradjeniTreningDTOS, HttpStatus.OK);
    }
}
