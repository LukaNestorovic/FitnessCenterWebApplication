package com.example.WebProg.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OdradjeniTrening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer ocena;

    @ManyToOne(fetch = FetchType.LAZY)
    private Trening trening;

    @ManyToOne(fetch = FetchType.LAZY)
    private Termin termin;

    @ManyToOne(fetch = FetchType.LAZY)
    private Clan clan;

    public OdradjeniTrening(){
    }

    public OdradjeniTrening(Integer ocena){
        this.ocena = ocena;
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

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }
}
