package com.example.WebProg.controller;

import com.example.WebProg.model.Termin;
import com.example.WebProg.model.dto.TerminDTO;
import com.example.WebProg.service.TerminService;
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
@RequestMapping(value = "/api/termini")
public class TerminController {
    private final TerminService terminService;

    @Autowired
    public TerminController(TerminService terminService) {
        this.terminService = terminService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> getTermin(@PathVariable("id") Long id) {
        Termin termin = this.terminService.findOne(id);

        TerminDTO terminDTO = new TerminDTO();
        terminDTO.setId(termin.getId());
        terminDTO.setCena(termin.getCena());
        terminDTO.setDatum_vreme(termin.getDatum_vreme());
        terminDTO.setId_trening(termin.getTrening().getId());

        return new ResponseEntity<>(terminDTO, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTermin() {
        List<Termin> terminList = this.terminService.findAll();

        List<TerminDTO> terminDTOS = new ArrayList<>();

        for(Termin termin: terminList) {
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getCena(), termin.getDatum_vreme(), termin.getTrening().getId());
            terminDTOS.add(terminDTO);
        }

        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }
}
