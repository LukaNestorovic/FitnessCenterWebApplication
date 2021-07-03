package com.example.WebProg.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FitnesCentar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String adresa;

    @Column
    private String email;

    @Column
    private String broj_telefona;

    @OneToMany(mappedBy = "fitnesCentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trener> treneri = new HashSet<>();

    @OneToMany(mappedBy = "fitnesCentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sala> sale = new HashSet<>();

    @OneToMany(mappedBy = "fitnesCentar",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> termini = new HashSet<>();

    public FitnesCentar(){
    }

    public FitnesCentar(String naziv, String adresa, String email, String broj_telefona){
        this.naziv = naziv;
        this.adresa = adresa;
        this.email = email;
        this.broj_telefona = broj_telefona;
    }

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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBroj_telefona() {
        return broj_telefona;
    }

    public void setBroj_telefona(String broj_telefona) {
        this.broj_telefona = broj_telefona;
    }

    public Set<Trener> getTreneri() {
        return treneri;
    }

    public void setTreneri(Set<Trener> treneri) {
        this.treneri = treneri;
    }

    public Set<Sala> getSale() {
        return sale;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }

    public Set<Termin> getTermini() {
        return termini;
    }

    public void setTermini(Set<Termin> termini) {
        this.termini = termini;
    }
}
