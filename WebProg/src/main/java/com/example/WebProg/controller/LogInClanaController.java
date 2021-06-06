package com.example.WebProg.controller;

import com.example.WebProg.model.Clan;
import com.example.WebProg.model.dto.ClanDTO2;
import com.example.WebProg.service.LogInClanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/login")
public class LogInClanaController {
    private final LogInClanaService logInClanaService;

    @Autowired
    public LogInClanaController(LogInClanaService logInClanaService) {
        this.logInClanaService = logInClanaService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClanDTO2>> getClan() {
        List<Clan> clanList = this.logInClanaService.findAll();

        List<ClanDTO2> clanDTOS = new ArrayList<>();

        for(Clan clan: clanList) {
            ClanDTO2 clanDTO = new ClanDTO2(clan.getId(), clan.getkorisnickoIme(), clan.getLozinka());
            clanDTOS.add(clanDTO);
        }

        return new ResponseEntity<>(clanDTOS, HttpStatus.OK);
    }
}
