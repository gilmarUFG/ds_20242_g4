package com.registro.vacina.RegistroVacina.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "confirmacao_lembrete")
public class ConfirmacaoLembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Gerado automaticamente pelo banco de dados

    @NotNull // Obrigatório
    @Column(name = "lembrete_id")
    private Integer lembreteId;

    @NotNull // Obrigatório
    @Column(name = "usuario")
    private String usuario; // CPF do paciente

    @Column(name = "data_confirmacao")
    private LocalDateTime dataConfirmacao; // Não obrigatório

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public LocalDateTime getDataConfirmacao() {
        return dataConfirmacao;
    }

    public void setDataConfirmacao(LocalDateTime dataConfirmacao) {
        this.dataConfirmacao = dataConfirmacao;
    }
}
