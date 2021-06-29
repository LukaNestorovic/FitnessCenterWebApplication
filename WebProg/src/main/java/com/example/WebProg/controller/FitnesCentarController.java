package com.example.WebProg.controller;

import com.example.WebProg.model.FitnesCentar;
import com.example.WebProg.model.dto.FitnesCentarDTO;
import com.example.WebProg.service.FitnesCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/fitnescentri")
public class FitnesCentarController {
    private final FitnesCentarService fitnesCentarService;

    @Autowired
    public FitnesCentarController(FitnesCentarService fitnesCentarService) {
        this.fitnesCentarService = fitnesCentarService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentarDTO> getFitnesCentar(@PathVariable("id") Long id) {
        FitnesCentar fitnesCentar = this.fitnesCentarService.findOne(id);

        FitnesCentarDTO fitnesCentarDTO = new FitnesCentarDTO();
        fitnesCentarDTO.setId(fitnesCentar.getId());
        fitnesCentarDTO.setNaziv(fitnesCentar.getNaziv());
        fitnesCentarDTO.setAdresa(fitnesCentar.getAdresa());
        fitnesCentarDTO.setEmail(fitnesCentar.getEmail());
        fitnesCentarDTO.setBroj_telefona(fitnesCentar.getBroj_telefona());

        return new ResponseEntity<>(fitnesCentarDTO, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnesCentarDTO>> getFitnesCentar() {
        List<FitnesCentar> fitnesCentarList = this.fitnesCentarService.findAll();

        List<FitnesCentarDTO> fitnesCentarDTOS = new ArrayList<>();

        for(FitnesCentar fitnesCentar: fitnesCentarList) {
            FitnesCentarDTO fitnesCentarDTO = new FitnesCentarDTO(fitnesCentar.getId(), fitnesCentar.getNaziv(), fitnesCentar.getAdresa(), fitnesCentar.getEmail(), fitnesCentar.getBroj_telefona());
            fitnesCentarDTOS.add(fitnesCentarDTO);
        }

        return new ResponseEntity<>(fitnesCentarDTOS, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentarDTO> createFitnesCentar(@RequestBody FitnesCentarDTO fitnesCentarDTO) throws Exception {
        FitnesCentar fitnesCentar = new FitnesCentar(fitnesCentarDTO.getNaziv(), fitnesCentarDTO.getAdresa(), fitnesCentarDTO.getEmail(), fitnesCentarDTO.getBroj_telefona());

        FitnesCentar newFitnesCentar = fitnesCentarService.create(fitnesCentar);

        FitnesCentarDTO newFitnesCentarDTO = new FitnesCentarDTO(newFitnesCentar.getId(), newFitnesCentar.getNaziv(), newFitnesCentar.getAdresa(), newFitnesCentar.getEmail(), newFitnesCentar.getBroj_telefona());

        return new ResponseEntity<>(newFitnesCentarDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentarDTO> updateFitnesCentar(@PathVariable Long id, @RequestBody FitnesCentarDTO fitnesCentarDTO) throws Exception {
        FitnesCentar fitnesCentar = new FitnesCentar(fitnesCentarDTO.getNaziv(), fitnesCentarDTO.getAdresa(), fitnesCentarDTO.getEmail(), fitnesCentarDTO.getBroj_telefona());
        fitnesCentar.setId(id);

        FitnesCentar updatedFC = fitnesCentarService.update(fitnesCentar);

        FitnesCentarDTO updatedFCDTO = new FitnesCentarDTO(updatedFC.getId(), updatedFC.getNaziv(), updatedFC.getAdresa(), updatedFC.getEmail(), updatedFC.getBroj_telefona());

        return new ResponseEntity<>(updatedFCDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFitnesCentar(@PathVariable Long id) {
        this.fitnesCentarService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
