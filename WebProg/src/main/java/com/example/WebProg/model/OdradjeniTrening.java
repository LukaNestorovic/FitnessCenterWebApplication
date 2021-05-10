package com.example.WebProg.model;

import javax.persistence.*;
import java.io.Serializable;

public class OdradjeniTrening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Trening trening;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Clan clan;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Clan clanOcena;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Clan getClanOcena() {
        return clanOcena;
    }

    public void setClanOcena(Clan clanOcena) {
        this.clanOcena = clanOcena;
    }
}
