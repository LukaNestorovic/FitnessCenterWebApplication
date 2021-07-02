package com.example.WebProg.service;

import com.example.WebProg.model.Sala;
import com.example.WebProg.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public Sala findOne(Long id){
        Sala sala = this.salaRepository.getOne(id);
        return sala;
    }

    public List<Sala> findByFitnes_centar_id(Long fitnesCentarId){
        List<Sala> salas = this.salaRepository.findByFitnes_centar_id(fitnesCentarId);
        return salas;
    }

    public Sala create(Sala sala) throws Exception{
        if(sala.getId() != null){
            throw new Exception("ID must be null!");
        }
        Sala newSala = this.salaRepository.save(sala);
        return newSala;
    }

    public void delete(Long id){
        this.salaRepository.deleteById(id);
    }

    public Sala update(Sala sala) throws Exception{
        Sala salaToUpdate = this.salaRepository.getOne(sala.getId());
        if(salaToUpdate == null){
            throw new Exception("Sala ne postoji");
        }

        salaToUpdate.setFitnes_centar(sala.getFitnes_centar());
        salaToUpdate.setKapacitet(sala.getKapacitet());
        salaToUpdate.setOznaka_sale(sala.getOznaka_sale());

        Sala savedSala = this.salaRepository.save(salaToUpdate);
        return savedSala;
    }
}
