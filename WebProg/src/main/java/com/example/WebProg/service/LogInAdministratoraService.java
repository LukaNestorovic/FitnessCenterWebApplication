package com.example.WebProg.service;

import com.example.WebProg.model.Administrator;
import com.example.WebProg.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogInAdministratoraService {
    @Autowired
    private AdministratorRepository administratorRepository;

    public Administrator findOne(Long id){
        Administrator administrator = this.administratorRepository.getOne(id);
        return administrator;
    }

    public List<Administrator> findAll(){
        List<Administrator> administrators = this.administratorRepository.findAll();
        return administrators;
    }
}
