package com.example.WebProg.model.dto;

import java.util.Date;

public class ClanDTO {
    private Long id;
    private String korisnicko_ime;
    private String lozinka;
    private String ime;
    private String prezime;
    private String kontakt_telefon;
    private String email;
    private Date datum_rodjenja;
    private String uloga;

    public ClanDTO() {
    }

    public ClanDTO(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_telefon, String email, Date datum_rodjenja, String uloga){
        this.id = id;
        this.korisnicko_ime = korisnicko_ime;
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

    public String getkorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setkorisnicko_ime(String korisnicko_ime) {
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
}
