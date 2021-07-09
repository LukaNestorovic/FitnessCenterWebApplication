package com.example.WebProg.controller;

import com.example.WebProg.model.*;
import com.example.WebProg.model.dto.PrijavljeniTreningDTO;
import com.example.WebProg.model.dto.SalaDTO;
import com.example.WebProg.service.PrijavljeniTreningService;
import com.example.WebProg.service.RegistracijaClanaService;
import com.example.WebProg.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/prijavljeni-treninzi")
public class PrijavljeniTreningController {
    private final RegistracijaClanaService clanService;
    private final PrijavljeniTreningService prijavljeniTreningService;
    private final TerminService terminService;

    @Autowired
    public PrijavljeniTreningController(RegistracijaClanaService clanService, PrijavljeniTreningService prijavljeniTreningService, TerminService terminService){
        this.clanService = clanService;
        this.prijavljeniTreningService = prijavljeniTreningService;
        this.terminService = terminService;
    }

    @GetMapping(value = "/za-clana/{clanId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PrijavljeniTreningDTO>> getPrijavljeniTreninzi(@PathVariable("clanId") Long clanId) {
        List<PrijavljeniTrening> prijavljeniTreningList = this.prijavljeniTreningService.findByClanId(clanId);

        List<PrijavljeniTreningDTO> prijavljeniTreningDTOS = new ArrayList<>();

        for(PrijavljeniTrening prijavljeniTrening: prijavljeniTreningList) {
            PrijavljeniTreningDTO prijavljeniTreningDTO = new PrijavljeniTreningDTO(prijavljeniTrening.getId(), prijavljeniTrening.getTermin().getTrening().getNaziv(), prijavljeniTrening.getTermin().getTrening().getTip_treninga(), prijavljeniTrening.getTermin().getDatum_vreme());
            prijavljeniTreningDTOS.add(prijavljeniTreningDTO);
        }

        return new ResponseEntity<>(prijavljeniTreningDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/za-clana/{clanId}/termin/{terminId}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrijavljeniTreningDTO> createPrijavljeniTrening(@RequestBody PrijavljeniTreningDTO prijavljeniTreningDTO,@PathVariable("clanId") Long clanId, @PathVariable("terminId") Long terminId) throws Exception {
        Clan clan = clanService.findOne(clanId);
        Termin termin = terminService.findOne(terminId);

        PrijavljeniTrening prijavljeniTrening = new PrijavljeniTrening();

        prijavljeniTrening.setClan(clan);
        prijavljeniTrening.setTermin(termin);

        PrijavljeniTrening newPrijavljeniTrening = prijavljeniTreningService.create(prijavljeniTrening);

        PrijavljeniTreningDTO newPrijavljeniTreningDTO = new PrijavljeniTreningDTO(newPrijavljeniTrening.getId(), newPrijavljeniTrening.getTermin().getTrening().getNaziv(), newPrijavljeniTrening.getTermin().getTrening().getTip_treninga(), newPrijavljeniTrening.getTermin().getDatum_vreme());

        return new ResponseEntity<>(newPrijavljeniTreningDTO, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/za-clana/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.prijavljeniTreningService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
