package com.example.WebProg.model.dto;

import java.time.LocalDateTime;

public class PrijavljeniTreningDTO {
    private Long id;
    private String naziv;
    private String tip_treninga;
    private LocalDateTime datum_vreme;

    public PrijavljeniTreningDTO(){}

    public PrijavljeniTreningDTO(Long id, String naziv, String tip_treninga, LocalDateTime datum_vreme){
        this.id = id;
        this.naziv = naziv;
        this.tip_treninga = tip_treninga;
        this.datum_vreme = datum_vreme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip_treninga() {
        return tip_treninga;
    }

    public void setTip_treninga(String tip_treninga) {
        this.tip_treninga = tip_treninga;
    }

    public LocalDateTime getDatum_vreme() {
        return datum_vreme;
    }

    public void setDatum_vreme(LocalDateTime datum_vreme) {
        this.datum_vreme = datum_vreme;
    }
}
