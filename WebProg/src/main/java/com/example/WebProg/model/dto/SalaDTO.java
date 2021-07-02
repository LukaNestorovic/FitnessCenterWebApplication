package com.example.WebProg.model.dto;

public class SalaDTO {
    private Long id;
    private Integer kapacitet;
    private String oznaka_sale;

    public SalaDTO() {
    }

    public SalaDTO(Long id, Integer kapacitet, String oznaka_sale){
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznaka_sale = oznaka_sale;
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

    public String getOznaka_sale() {
        return oznaka_sale;
    }

    public void setOznaka_sale(String oznaka_sale) {
        this.oznaka_sale = oznaka_sale;
    }
}
