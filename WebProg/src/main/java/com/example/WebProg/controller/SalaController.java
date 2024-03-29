package com.example.WebProg.controller;

import com.example.WebProg.model.FitnesCentar;
import com.example.WebProg.model.Sala;
import com.example.WebProg.model.dto.FitnesCentarDTO;
import com.example.WebProg.model.dto.SalaDTO;
import com.example.WebProg.service.FitnesCentarService;
import com.example.WebProg.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/sale")
public class SalaController {
    private final SalaService salaService;
    private final FitnesCentarService fitnesCentarService;

    @Autowired
    public SalaController(SalaService salaService, FitnesCentarService fitnesCentarService) {
        this.salaService = salaService;
        this.fitnesCentarService = fitnesCentarService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> getSala(@PathVariable("id") Long id) {
        Sala sala = this.salaService.findOne(id);

        SalaDTO salaDTO = new SalaDTO();
        salaDTO.setId(sala.getId());
        salaDTO.setKapacitet(sala.getKapacitet());
        salaDTO.setOznaka_sale(sala.getOznakaSale());

        return new ResponseEntity<>(salaDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/za-fitnes/{fitnesCentarId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaDTO>> getSale(@PathVariable("fitnesCentarId") Long fitnesCentarId) {
        List<Sala> salaList = this.salaService.findByFitnesCentarId(fitnesCentarId);

        List<SalaDTO> salaDTOS = new ArrayList<>();

        for(Sala sala: salaList) {
            SalaDTO salaDTO = new SalaDTO(sala.getId(), sala.getKapacitet(), sala.getOznakaSale());
            salaDTOS.add(salaDTO);
        }

        return new ResponseEntity<>(salaDTOS, HttpStatus.OK);
    }

    @DeleteMapping(value = "/za-fitnes/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long id) {
        this.salaService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/za-fitnes/{fitnesCentarId}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> createSala(@RequestBody SalaDTO salaDTO,@PathVariable("fitnesCentarId") Long fitnesCentarId) throws Exception {
        FitnesCentar fitnesCentar = fitnesCentarService.findOne(fitnesCentarId);

        Sala sala = new Sala(salaDTO.getKapacitet(), salaDTO.getOznaka_sale());

        sala.setFitnesCentar(fitnesCentar);

        Sala newSala = salaService.create(sala);

        SalaDTO newSalaDTO = new SalaDTO(newSala.getId(), newSala.getKapacitet(), newSala.getOznakaSale());

        return new ResponseEntity<>(newSalaDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> updateSale(@PathVariable Long id, @RequestBody SalaDTO salaDTO) throws Exception {
        Sala sala = new Sala(salaDTO.getKapacitet(), salaDTO.getOznaka_sale());
        sala.setId(id);

        Sala updatedSala = salaService.update(sala);

        SalaDTO updatedSalaDTO = new SalaDTO(updatedSala.getId(), updatedSala.getKapacitet(), updatedSala.getOznakaSale());

        return new ResponseEntity<>(updatedSalaDTO, HttpStatus.OK);
    }
}