package com.registro.vacina.RegistroVacina.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class HistoricoVacinacaoDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataVacinacao;
    private String loteVacinacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private Date anoVencimneto;
    private String quantidadeDoses;
    private String nomeVacina;

    public Date getDataVacinacao() {
        return dataVacinacao;
    }

    public void setDataVacinacao(Date dataVacinacao) {
        this.dataVacinacao = dataVacinacao;
    }

    public String getLoteVacinacao() {
        return loteVacinacao;
    }

    public void setLoteVacinacao(String loteVacinacao) {
        this.loteVacinacao = loteVacinacao;
    }

    public Date getAnoVencimneto() {
        return anoVencimneto;
    }

    public void setAnoVencimneto(Date anoVencimneto) {
        this.anoVencimneto = anoVencimneto;
    }

    public String getQuantidadeDoses() {
        return quantidadeDoses;
    }

    public void setQuantidadeDoses(String quantidadeDoses) {
        this.quantidadeDoses = quantidadeDoses;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }
}
