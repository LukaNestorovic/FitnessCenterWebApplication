package com.example.WebProg.model.dto;

import java.util.List;

public class TreningDTO {
    private Long id;
    private String naziv;
    private String opis;
    private String tip_treninga;
    private Integer trajanje;
    private List<TerminDTO> terminList;

    public TreningDTO() {
    }

    public TreningDTO(Long id, String naziv, String opis, String tip_treninga, Integer trajanje, List<TerminDTO> terminList){
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tip_treninga = tip_treninga;
        this.trajanje = trajanje;
        this.terminList = terminList;
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

    public List<TerminDTO> getTerminList() {
        return terminList;
    }

    public void setTerminList(List<TerminDTO> terminList) {
        this.terminList = terminList;
    }
}
