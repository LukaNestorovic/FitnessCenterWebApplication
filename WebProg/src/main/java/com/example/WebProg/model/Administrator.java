package com.example.WebProg.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Administrator implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String korisnicko_ime;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
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
}
