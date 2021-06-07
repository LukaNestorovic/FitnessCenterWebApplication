package com.example.WebProg.controller;

import com.example.WebProg.model.Trener;
import com.example.WebProg.model.dto.TrenerDTO2;
import com.example.WebProg.service.LogInTreneraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/login")
public class LogInTreneraController {
    private final LogInTreneraService logInTreneraService;

    @Autowired
    public LogInTreneraController(LogInTreneraService logInTreneraService){
        this.logInTreneraService = logInTreneraService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrenerDTO2>> getTrener() {
        List<Trener> trenerList = this.logInTreneraService.findAll();

        List<TrenerDTO2> trenerDTOS = new ArrayList<>();

        for(Trener trener: trenerList) {
            TrenerDTO2 trenerDTO = new TrenerDTO2(trener.getId(), trener.getKorisnicko_ime(), trener.getLozinka());
            trenerDTOS.add(trenerDTO);
        }

        return new ResponseEntity<>(trenerDTOS, HttpStatus.OK);
    }
}
