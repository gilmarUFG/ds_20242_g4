package com.registro.vacina.RegistroVacina.dto;


import com.registro.vacina.RegistroVacina.entities.FaixaEtaria;
import lombok.*;


public class CalendarioDto {

    private int calendarioId;
    private String categoria;
    private int doses;
    private FaixaEtaria faixa_etaria;
    private String vacinas;



    //Criar para as demais atributos/ colunas


    public int getDoses() {
        return doses;
    }

    public void setDoses(int doses) {
        this.doses = doses;
    }



    public int getCalendarioId() {
        return calendarioId;
    }

    public void setCalendarioId(int calendarioId) {
        this.calendarioId = calendarioId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getVacinas() {
        return vacinas;
    }

    public void setVacinas(String vacinas) {
        this.vacinas = vacinas;
    }

    public FaixaEtaria getFaixa_etaria() {
        return faixa_etaria;
    }

    public void setFaixa_etaria(FaixaEtaria faixa_etaria) {
        this.faixa_etaria = faixa_etaria;
    }
}
