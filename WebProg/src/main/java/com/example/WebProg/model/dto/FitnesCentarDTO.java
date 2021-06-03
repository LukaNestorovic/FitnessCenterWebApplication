package com.example.WebProg.model.dto;

public class FitnesCentarDTO {
    private Long id;
    private String naziv;
    private String adresa;
    private String email;
    private String broj_telefona;

    public FitnesCentarDTO(){
    }

    public FitnesCentarDTO(Long id, String naziv, String adresa, String email, String broj_telefona){
        this.id = id;
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
}
