package com.example.WebProg.model.dto;

import java.time.LocalDateTime;

public class TerminDTO {
    private Long id;
    private Double cena;
    private LocalDateTime datum_vreme;
    private Long id_trening;

    public TerminDTO() {
    }

    public TerminDTO(Long id, Double cena, LocalDateTime datum_vreme, Long id_trening){
        this.id = id;
        this.cena = cena;
        this.datum_vreme = datum_vreme;
        this.id_trening = id_trening;
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

    public Long getId_trening() {
        return id_trening;
    }

    public void setId_trening(Long id_trening) {
        this.id_trening = id_trening;
    }
}
