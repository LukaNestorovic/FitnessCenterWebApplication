package com.example.WebProg.service;

import com.example.WebProg.model.FitnesCentar;
import com.example.WebProg.repository.FitnesCentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnesCentarService {

    @Autowired
    private FitnesCentarRepository fitnesCentarRepository;

    public FitnesCentar findOne(Long id) {
        FitnesCentar fitnesCentar = this.fitnesCentarRepository.getOne(id);
        return fitnesCentar;
    }

    public List<FitnesCentar> findAll() {
        List<FitnesCentar> fitnesCentars = this.fitnesCentarRepository.findAll();
        return fitnesCentars;
    }

    public FitnesCentar create(FitnesCentar fitnesCentar) throws Exception {
        if (fitnesCentar.getId() != null) {
            throw new Exception("ID must be null!");
        }
        FitnesCentar newFitnesCentar = this.fitnesCentarRepository.save(fitnesCentar);
        return newFitnesCentar;
    }
}
