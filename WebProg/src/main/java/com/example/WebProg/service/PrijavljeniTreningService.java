package com.example.WebProg.service;

import com.example.WebProg.model.PrijavljeniTrening;
import com.example.WebProg.repository.PrijavljeniTreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrijavljeniTreningService {
    @Autowired
    private PrijavljeniTreningRepository prijavljeniTreningRepository;

    public List<PrijavljeniTrening> findByClanId(Long clanId) {
        List<PrijavljeniTrening> prijavljeniTrenings = this.prijavljeniTreningRepository.findByTerminId(clanId);
        return prijavljeniTrenings;
    }

    public void delete(Long id) {
        this.prijavljeniTreningRepository.deleteById(id);
    }

    public PrijavljeniTrening create(PrijavljeniTrening prijavljeniTrening) throws Exception{
        if(prijavljeniTrening.getId() != null){
            throw new Exception("ID must be null!");
        }
        PrijavljeniTrening newPrijavljeniTrening = this.prijavljeniTreningRepository.save(prijavljeniTrening);
        return newPrijavljeniTrening;
    }
}
