package com.example.WebProg.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class OdradjeniTrening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer ocena;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Trening trening;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Clan clan;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Clan clanOcena;

    @OneToMany(mappedBy = "odradjeni_trening",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> termin = new HashSet<>();

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
}
