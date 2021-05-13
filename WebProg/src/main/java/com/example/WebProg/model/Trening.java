package com.example.WebProg.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String opis;

    @Column
    private String tip_treninga;

    @Column
    private Integer trajanje;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Trener trener;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Clan clan;

    @OneToMany(mappedBy = "trening",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OdradjeniTrening> odradjeni_treninzi = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTip_treninga() {
        return tip_treninga;
    }

    public void setTip_treninga(String tip_treninga) {
        this.tip_treninga = tip_treninga;
    }

    public Integer getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Integer trajanje) {
        this.trajanje = trajanje;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
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
}
