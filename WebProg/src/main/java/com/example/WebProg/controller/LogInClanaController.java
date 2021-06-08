package com.example.WebProg.controller;

import com.example.WebProg.model.Clan;
import com.example.WebProg.model.dto.ClanDTO2;
import com.example.WebProg.service.LogInClanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/loginclana")
public class LogInClanaController {
    private final LogInClanaService logInClanaService;

    @Autowired
    public LogInClanaController(LogInClanaService logInClanaService) {
        this.logInClanaService = logInClanaService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO2> getClan(@RequestBody ClanDTO2 clanDTO2) {
        ClanDTO2 clanDTO3 = new ClanDTO2(clanDTO2.getId(), clanDTO2.getKorisnicko_ime(), clanDTO2.getLozinka());
        List<Clan> clanList = this.logInClanaService.findAll();

        for(Clan clan: clanList) {
            if(clan.getkorisnickoIme().equals(clanDTO3.getKorisnicko_ime())){
                if(clan.getLozinka().equals(clanDTO3.getLozinka())) {
                    return new ResponseEntity<>(clanDTO3, HttpStatus.OK);
                }
                else {
                    return new ResponseEntity<>(clanDTO3, HttpStatus.BAD_REQUEST);
                }
                }
            else {
                return new ResponseEntity<>(clanDTO3, HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(clanDTO3, HttpStatus.NOT_FOUND);
    }


}
