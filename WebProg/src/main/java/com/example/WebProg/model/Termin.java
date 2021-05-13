package com.example.WebProg.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Termin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double cena;

    @Column
    private LocalDateTime datum_vreme;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Sala sala;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Clan clan;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private OdradjeniTrening odradjeni_trening;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FitnesCentar fitnes_centar;

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

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public FitnesCentar getFitnes_centar() {
        return fitnes_centar;
    }

    public void setFitnes_centar(FitnesCentar fitnes_centar) {
        this.fitnes_centar = fitnes_centar;
    }

    public OdradjeniTrening getOdradjeni_trening() {
        return odradjeni_trening;
    }

    public void setOdradjeni_trening(OdradjeniTrening odradjeni_trening) {
        this.odradjeni_trening = odradjeni_trening;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }
}
