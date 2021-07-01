package com.example.WebProg.service;

import com.example.WebProg.model.Termin;
import com.example.WebProg.repository.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminService {

    @Autowired
    private TerminRepository terminRepository;

    public Termin findOne(Long id) {
        Termin termin = this.terminRepository.getOne(id);
        return termin;
    }

    public List<Termin> findByTreningId(Long treningId) {
        List<Termin> termins = this.terminRepository.findByTreningId(treningId);
        return termins;
    }
}
