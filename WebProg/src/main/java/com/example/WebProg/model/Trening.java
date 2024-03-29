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

    @Column(unique = true)
    private String naziv;

    @Column
    private String opis;

    @Column
    private String tip_treninga;

    @Column
    private Integer trajanje;

    @ManyToOne(fetch = FetchType.LAZY)
    private Trener trener;

    @OneToMany(mappedBy = "trening",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OdradjeniTrening> odradjeni_treninzi = new HashSet<>();

    @OneToMany(mappedBy = "trening",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> termini = new HashSet<>();

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

    public Set<OdradjeniTrening> getOdradjeni_treninzi() {
        return odradjeni_treninzi;
    }

    public void setOdradjeni_treninzi(Set<OdradjeniTrening> odradjeni_treninzi) {
        this.odradjeni_treninzi = odradjeni_treninzi;
    }

    public Set<Termin> getTermini() {
        return termini;
    }

    public void setTermini(Set<Termin> termini) {
        this.termini = termini;
    }
}
