package com.example.WebProg.service;

import com.example.WebProg.model.Trener;
import com.example.WebProg.repository.RegistracijaTreneraRepository;
import com.example.WebProg.repository.TrenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogInTreneraService {
    @Autowired
    private TrenerRepository trenerRepository;
    private RegistracijaTreneraRepository registracijaTreneraRepository;

    public Trener findOne(Long id) {
        Trener trener = this.registracijaTreneraRepository.getOne(id);
        return trener;
    }

    public List<Trener> findAll() {
        List<Trener> treners = this.registracijaTreneraRepository.findAll();
        return treners;
    }
}
