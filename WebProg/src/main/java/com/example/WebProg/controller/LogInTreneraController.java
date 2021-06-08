package com.example.WebProg.controller;

import com.example.WebProg.model.Trener;
import com.example.WebProg.model.dto.TrenerDTO2;
import com.example.WebProg.service.LogInTreneraService;
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
@RequestMapping(value = "/api/logintrenera")
public class LogInTreneraController {
    private final LogInTreneraService logInTreneraService;

    @Autowired
    public LogInTreneraController(LogInTreneraService logInTreneraService){
        this.logInTreneraService = logInTreneraService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO2> getTrener(@RequestBody TrenerDTO2 trenerDTO2){
        TrenerDTO2 trenerDTO3 = new TrenerDTO2(trenerDTO2.getId(), trenerDTO2.getKorisnicko_ime(), trenerDTO2.getLozinka());
        List<Trener> trenerList = this.logInTreneraService.findAll();

        for(Trener trener : trenerList){
            if(trener.getKorisnicko_ime().equals(trenerDTO3.getKorisnicko_ime())){
                if(trener.getLozinka().equals(trenerDTO3.getLozinka())){
                    return new ResponseEntity<>(trenerDTO3, HttpStatus.OK);
                }
                else{
                    return new ResponseEntity<>(trenerDTO3, HttpStatus.BAD_REQUEST);
                }
            }
            else{
                return new ResponseEntity<>(trenerDTO3, HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(trenerDTO3, HttpStatus.NOT_FOUND);
    }
}
