package com.example.WebProg.controller;

import com.example.WebProg.model.Administrator;
import com.example.WebProg.model.Trener;
import com.example.WebProg.model.dto.AdministratorDTO;
import com.example.WebProg.model.dto.TrenerDTO2;
import com.example.WebProg.service.LogInAdministratoraService;
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
@RequestMapping(value = "/api/loginadministratora")
public class LogInAdministratoraController {
    private final LogInAdministratoraService logInAdministratoraService;

    @Autowired
    public LogInAdministratoraController(LogInAdministratoraService logInAdministratoraService){
        this.logInAdministratoraService = logInAdministratoraService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdministratorDTO> getAdministrator(@RequestBody AdministratorDTO administratorDTO){
        AdministratorDTO administratorDTO1 = new AdministratorDTO(administratorDTO.getId(), administratorDTO.getKorisnicko_ime(), administratorDTO.getLozinka());
        List<Administrator> administratorList = this.logInAdministratoraService.findAll();

        for(Administrator administrator : administratorList){
            if(administrator.getKorisnicko_ime().equals(administratorDTO1.getKorisnicko_ime())){
                if(administrator.getLozinka().equals(administratorDTO1.getLozinka())){
                    return new ResponseEntity<>(administratorDTO1, HttpStatus.OK);
                }
                else{
                    return new ResponseEntity<>(administratorDTO1, HttpStatus.BAD_REQUEST);
                }
            }
        }
        return new ResponseEntity<>(administratorDTO1,HttpStatus.NOT_FOUND);
    }
}
