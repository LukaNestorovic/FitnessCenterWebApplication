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
    private Set<OdradjeniTrening> odradjeni_treninzi = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FitnesCentar fitnes_centar;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Trening trening;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Clan odradjeni_trening;

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

    public FitnesCentar getFitnes_centar() {
        return fitnes_centar;
    }

    public void setFitnes_centar(FitnesCentar fitnes_centar) {
        this.fitnes_centar = fitnes_centar;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Set<OdradjeniTrening> getOdradjeni_treninzi() {
        return odradjeni_treninzi;
    }

    public void setOdradjeni_treninzi(Set<OdradjeniTrening> odradjeni_treninzi) {
        this.odradjeni_treninzi = odradjeni_treninzi;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Clan getOdradjeni_trening() {
        return odradjeni_trening;
    }

    public void setOdradjeni_trening(Clan odradjeni_trening) {
        this.odradjeni_trening = odradjeni_trening;
    }

    public Clan getOcena() {
        return ocena;
    }

    public void setOcena(Clan ocena) {
        this.ocena = ocena;
    }
}
