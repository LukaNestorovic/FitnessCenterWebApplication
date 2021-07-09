package com.example.WebProg.service;

import com.example.WebProg.model.OdradjeniTrening;
import com.example.WebProg.model.OdradjeniTrening;
import com.example.WebProg.model.PrijavljeniTrening;
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

    public List<OdradjeniTrening> findByClanId(Long clanId) {
        List<OdradjeniTrening> odradjeniTrenings = this.odradjeniTreningRepository.findByClanId(clanId);
        return odradjeniTrenings;
    }

    public OdradjeniTrening update(OdradjeniTrening odradjeniTrening) throws Exception{
        OdradjeniTrening odradjeniTreningToUpdate = this.odradjeniTreningRepository.getOne(odradjeniTrening.getId());
        if(odradjeniTreningToUpdate == null){
            throw new Exception("OdradjeniTrening ne postoji");
        }

        odradjeniTreningToUpdate.setOcena(odradjeniTrening.getOcena());

        OdradjeniTrening savedOdradjeniTrening = this.odradjeniTreningRepository.save(odradjeniTreningToUpdate);
        return savedOdradjeniTrening;
    }

    public OdradjeniTrening create(OdradjeniTrening odradjeniTrening) throws Exception{
        if(odradjeniTrening.getId() != null){
            throw new Exception("ID must be null!");
        }
        OdradjeniTrening newOdradjeniTrening = this.odradjeniTreningRepository.save(odradjeniTrening);
        return newOdradjeniTrening;
    }
}
