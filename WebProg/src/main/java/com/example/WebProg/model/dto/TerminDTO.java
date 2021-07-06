package com.example.WebProg.model.dto;

import java.time.LocalDateTime;

public class TerminDTO {
    private Long id;
    private Double cena;
    private LocalDateTime datum_vreme;
    private String oznaka_sale;

    public TerminDTO() {
    }

    public TerminDTO(Long id, Double cena, LocalDateTime datum_vreme, String oznaka_sale){
        this.id = id;
        this.cena = cena;
        this.datum_vreme = datum_vreme;
        this.oznaka_sale = oznaka_sale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public LocalDateTime getDatum_vreme() {
        return datum_vreme;
    }

    public void setDatum_vreme(LocalDateTime datum_vreme) {
        this.datum_vreme = datum_vreme;
    }

}
