package com.example.WebProg.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Clan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String korisnickoIme;

    @Column
    private String lozinka;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column(unique = true)
    private String kontakt_telefon;

    @Column(unique = true)
    private String email;

    @Column
    private Date datum_rodjenja;

    @Column
    private String uloga;

    @Column
    private Boolean aktivan;

    @OneToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> odradjeni_treninzi = new HashSet<>();

    @OneToMany(mappedBy = "clan",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> ocena = new HashSet<>();

    @OneToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> prijavljeni_treninzi = new HashSet<>();

    public Clan() {
    }

    public Clan(String korisnickoIme, String lozinka, String ime, String prezime, String kontakt_telefon, String email, Date datum_rodjenja, String uloga){
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontakt_telefon = kontakt_telefon;
        this.email = email;
        this.datum_rodjenja = datum_rodjenja;
        this.uloga = uloga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getkorisnickoIme() {
        return korisnickoIme;
    }

    public void setkorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKontakt_telefon() {
        return kontakt_telefon;
    }

    public void setKontakt_telefon(String kontakt_telefon) {
        this.kontakt_telefon = kontakt_telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Set<Termin> getPrijavljeni_treninzi() {
        return prijavljeni_treninzi;
    }

    public void setPrijavljeni_treninzi(Set<Termin> prijavljeni_treninzi) {
        this.prijavljeni_treninzi = prijavljeni_treninzi;
    }

    public Set<Termin> getOdradjeni_treninzi() {
        return odradjeni_treninzi;
    }

    public void setOdradjeni_treninzi(Set<Termin> odradjeni_treninzi) {
        this.odradjeni_treninzi = odradjeni_treninzi;
    }

    public Set<Termin> getOcena() {
        return ocena;
    }

    public void setOcena(Set<Termin> ocena) {
        this.ocena = ocena;
    }
}
