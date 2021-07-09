package com.example.WebProg.controller;

import com.example.WebProg.model.Termin;
import com.example.WebProg.model.Trening;
import com.example.WebProg.model.dto.TerminDTO;
import com.example.WebProg.model.dto.TreningDTO;
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
@RequestMapping(value = "/api/treninzi")
public class TreningController {
    private final TreningService treningService;

    @Autowired
    public TreningController(TreningService treningService) {
        this.treningService = treningService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> getTrening(@PathVariable("id") Long id) {
        Trening trening = this.treningService.findOne(id);

        TreningDTO treningDTO = new TreningDTO();
        treningDTO.setId(trening.getId());
        treningDTO.setNaziv(trening.getNaziv());
        treningDTO.setOpis(trening.getOpis());
        treningDTO.setTip_treninga(trening.getTip_treninga());
        treningDTO.setTrajanje(trening.getTrajanje());

        return new ResponseEntity<>(treningDTO, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreninge() {
        List<Trening> treningList = this.treningService.findAll();

        List<TreningDTO> treningDTOS = new ArrayList<>();

        for(Trening trening: treningList) {
            TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(), trening.getTip_treninga(), trening.getTrajanje());
            treningDTOS.add(treningDTO);
        }

        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{trenerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreningeId(@PathVariable("trenerId") Long trenerId) {
        List<Trening> treningList = this.treningService.findByTrenerId(trenerId);

        List<TreningDTO> treningDTOS = new ArrayList<>();

        for(Trening trening: treningList) {
            TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(), trening.getTip_treninga(), trening.getTrajanje());
            treningDTOS.add(treningDTO);
        }

        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }
}
