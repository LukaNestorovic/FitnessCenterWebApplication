package com.example.WebProg.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PrijavljeniTrening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Termin termin;

    @ManyToOne(fetch = FetchType.LAZY)
    private Clan clan;

    public PrijavljeniTrening(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
