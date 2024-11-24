package com.registro.vacina.RegistroVacina.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalendarioDto {
    private int calendarioId;
    private String categoria;
    private String doses;
    @JsonProperty(value = "faixa_etaria")
    private FaixaEtariaDTO faixaEtariaObjeto;
    //priavate visibilidade do atributo > qual Objeto vc vai querer isnatnciar> Nome da váriavel que vc vai usar p fazer operação
    private String vacinas;

    //Criar para as demais atributos/ colunas
    public String getDoses() {
        return doses;
    }

    public void setDoses(String doses) {
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

    public FaixaEtariaDTO getFaixaEtariaObjeto() {
        return faixaEtariaObjeto;
    }

    public void setFaixaEtariaObjeto(FaixaEtariaDTO faixaEtariaObjeto) {
        this.faixaEtariaObjeto = faixaEtariaObjeto;
    }
}
