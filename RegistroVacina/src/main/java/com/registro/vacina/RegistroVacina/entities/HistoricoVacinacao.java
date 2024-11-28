package com.registro.vacina.RegistroVacina.entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "historico_vacina")
public class HistoricoVacinacao {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "paciente_id")
    private int pacienteId;

    @Column ( name = "dose_id")
    private int dose;

    @Column(name = "data_vacinacao")
    private Date dataVacinacao;

    @Column(name = "lote_vacinacao")
    private String  loteVacinacao;

    @Column(name = "ano_vencimento")
    private Date anoVencimento;

    @Column(name = "vacina_id")
    private int vacina;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }


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

    public Date getAnoVencimento() {
        return anoVencimento;
    }

    public void setAnoVencimento(Date anoVencimento) {
        this.anoVencimento = anoVencimento;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public int getVacina() {
        return vacina;
    }

    public void setVacina(int vacina) {
        this.vacina = vacina;
    }
}
