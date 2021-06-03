package com.example.WebProg.service;

import com.example.WebProg.model.Trening;
import com.example.WebProg.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreningService {

    @Autowired
    private TreningRepository treningRepository;

    public Trening findOne(Long id) {
        Trening trening = this.treningRepository.getOne(id);
        return trening;
    }

    public List<Trening> findAll() {
        List<Trening> treninzi = this.treningRepository.findAll();
        return treninzi;
    }
}
