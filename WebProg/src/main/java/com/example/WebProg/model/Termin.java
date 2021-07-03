package com.example.WebProg.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "termin",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OdradjeniTrening> odradjeniTreninzi = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FitnesCentar fitnesCentar;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Trening trening;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Clan odradjeniTrening;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Clan ocena;

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

    public FitnesCentar getFitnesCentar() {
        return fitnesCentar;
    }

    public void setFitnesCentar(FitnesCentar fitnesCentar) {
        this.fitnesCentar = fitnesCentar;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Set<OdradjeniTrening> getOdradjeniTreninzi() {
        return odradjeniTreninzi;
    }

    public void setOdradjeniTreninzi(Set<OdradjeniTrening> odradjeniTreninzi) {
        this.odradjeniTreninzi = odradjeniTreninzi;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Clan getOdradjeniTrening() {
        return odradjeniTrening;
    }

    public void setOdradjeniTrening(Clan odradjeniTrening) {
        this.odradjeniTrening = odradjeniTrening;
    }

    public Clan getOcena() {
        return ocena;
    }

    public void setOcena(Clan ocena) {
        this.ocena = ocena;
    }
}
