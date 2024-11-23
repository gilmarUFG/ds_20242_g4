package com.registro.vacina.RegistroVacina.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "confirmacao_lembrete")
public class ConfirmacaoLembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "lembrete_id")
    private int lembreteId;

    @Column(name = "paciente_id")
    private int pacienteId;

    @Column(name = "data_confirmacao")
    private LocalDateTime dataConfirmacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLembreteId() {
        return lembreteId;
    }

    public void setLembreteId(int lembreteId) {
        this.lembreteId = lembreteId;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public LocalDateTime getDataConfirmacao() {
        return dataConfirmacao;
    }

    public void setDataConfirmacao(LocalDateTime dataConfirmacao) {
        this.dataConfirmacao = dataConfirmacao;
    }
}

