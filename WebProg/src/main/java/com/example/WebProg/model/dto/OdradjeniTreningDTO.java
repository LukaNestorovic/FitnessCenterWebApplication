package com.example.WebProg.model.dto;

import java.time.LocalDateTime;

public class OdradjeniTreningDTO {
    private Long id;
    private Integer ocena;
    private String naziv;
    private String tip_treninga;
    private LocalDateTime datum_vreme;

    public OdradjeniTreningDTO(){
    }

    public OdradjeniTreningDTO(Long id, Integer ocena, String naziv, String tip_treninga, LocalDateTime datum_vreme){
        this.id = id;
        this.ocena = ocena;
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

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
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
