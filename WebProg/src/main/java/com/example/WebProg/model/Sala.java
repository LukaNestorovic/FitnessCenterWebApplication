package com.example.WebProg.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer kapacitet;

    @Column
    private String oznakaSale;

    @ManyToOne(fetch = FetchType.LAZY)
    private FitnesCentar fitnesCentar;

    @OneToMany(mappedBy = "sala",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> termin = new HashSet<>();

    public Sala(){
    }

    public Sala(Integer kapacitet, String oznakaSale){
        this.kapacitet = kapacitet;
        this.oznakaSale = oznakaSale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(Integer kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getOznakaSale() {
        return oznakaSale;
    }

    public void setOznakaSale(String oznakaSale) {
        this.oznakaSale = oznakaSale;
    }

    public FitnesCentar getFitnesCentar() {
        return fitnesCentar;
    }

    public void setFitnesCentar(FitnesCentar fitnesCentar) {
        this.fitnesCentar = fitnesCentar;
    }

}
