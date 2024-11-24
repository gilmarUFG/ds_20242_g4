package com.registro.vacina.RegistroVacina.dto;

import jakarta.validation.constraints.NotNull;

public class ConfirmacaoLembreteDTO {

    @NotNull // Obrigatório
    private Integer lembreteId;

    @NotNull // Obrigatório
    private String usuario; // CPF do paciente

    private String dataConfirmacao; // Não obrigatório

    // Getters e Setters
    public Integer getLembreteId() {
        return lembreteId;
    }

    public void setLembreteId(Integer lembreteId) {
        this.lembreteId = lembreteId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDataConfirmacao() {
        return dataConfirmacao;
    }

    public void setDataConfirmacao(String dataConfirmacao) {
        this.dataConfirmacao = dataConfirmacao;
    }
}
