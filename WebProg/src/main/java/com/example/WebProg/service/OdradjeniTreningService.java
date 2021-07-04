package com.example.WebProg.service;

import com.example.WebProg.model.OdradjeniTrening;
import com.example.WebProg.repository.OdradjeniTreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdradjeniTreningService {
    @Autowired
    private OdradjeniTreningRepository odradjeniTreningRepository;

    public OdradjeniTrening findOne(Long id) {
        OdradjeniTrening odradjeniTrening = this.odradjeniTreningRepository.getOne(id);
        return odradjeniTrening;
    }

    public List<OdradjeniTrening> findAll() {
        List<OdradjeniTrening> odradjeniTrenings = this.odradjeniTreningRepository.findAll();
        return odradjeniTrenings;
    }
}
