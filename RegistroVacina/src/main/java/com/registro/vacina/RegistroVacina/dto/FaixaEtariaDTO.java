package com.registro.vacina.RegistroVacina.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class FaixaEtariaDTO{

    @JsonProperty(value= "de")
    private  String mesesinicial;
    @JsonProperty(value = "ate")
    private String mesesfinal;

    public String getMesesinicial() {
        return mesesinicial;
    }

    public void setMesesinicial(String mesesinicial) {
        this.mesesinicial = mesesinicial;
    }

    public String getMesesfinal() {
        return mesesfinal;
    }

    public void setMesesfinal( String mesesfinal) {
        this.mesesfinal = mesesfinal;
    }
}
