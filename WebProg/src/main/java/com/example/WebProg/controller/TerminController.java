package com.example.WebProg.controller;

import com.example.WebProg.model.FitnesCentar;
import com.example.WebProg.model.Sala;
import com.example.WebProg.model.Termin;
import com.example.WebProg.model.Trening;
import com.example.WebProg.model.dto.SalaDTO;
import com.example.WebProg.model.dto.TerminDTO;
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
@RequestMapping(value = "/api/termini")
public class TerminController {
    private final TerminService terminService;
    private final TreningService treningService;

    @Autowired
    public TerminController(TerminService terminService, TreningService treningService) {
        this.terminService = terminService;
        this.treningService = treningService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> getTermin(@PathVariable("id") Long id) {
        Termin termin = this.terminService.findOne(id);

        TerminDTO terminDTO = new TerminDTO();
        terminDTO.setId(termin.getId());
        terminDTO.setCena(termin.getCena());
        terminDTO.setDatum_vreme(termin.getDatum_vreme());

        return new ResponseEntity<>(terminDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/za-trening/{treningId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTermini(@PathVariable("treningId") Long treningId) {
        List<Termin> terminList = this.terminService.findByTreningId(treningId);

        List<TerminDTO> terminDTOS = new ArrayList<>();

        for(Termin termin: terminList) {
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getCena(), termin.getDatum_vreme());
            terminDTOS.add(terminDTO);
        }

        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }

    @DeleteMapping(value = "/za-trening/{id}")
    public ResponseEntity<Void> deleteTermin(@PathVariable Long id) {
        this.terminService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/za-trening/{treningId}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> createTermin(@RequestBody TerminDTO terminDTO, @PathVariable("treningId") Long treningId) throws Exception {
        Trening trening = treningService.findOne(treningId);

        Termin termin = new Termin(terminDTO.getCena(), terminDTO.getDatum_vreme());

        termin.setTrening(trening);

        Termin newTermin = terminService.create(termin);

        TerminDTO newTerminDTO = new TerminDTO(newTermin.getId(), newTermin.getCena(), newTermin.getDatum_vreme());

        return new ResponseEntity<>(newTerminDTO, HttpStatus.CREATED);
    }
}
