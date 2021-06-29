package com.example.WebProg.service;

import com.example.WebProg.model.Trener;
import com.example.WebProg.repository.TrenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistracijaTreneraService {

    @Autowired
    private TrenerRepository trenerRepository;

    public Trener findOne(Long id) {
        Trener trener = this.trenerRepository.getOne(id);
        return trener;
    }

    public List<Trener> findAll() {
        List<Trener> treners = this.trenerRepository.findAll();
        return treners;
    }

    public Trener create(Trener trener) throws Exception {
        if (trener.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Trener newTrener = this.trenerRepository.save(trener);
        return newTrener;
    }

    public void delete(Long id) {
        this.trenerRepository.deleteById(id);
    }
}
