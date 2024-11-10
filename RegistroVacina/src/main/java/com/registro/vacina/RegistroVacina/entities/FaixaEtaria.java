package com.registro.vacina.RegistroVacina.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "faixa_etaria")
public class FaixaEtaria {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "meses_inicial")
    private int mesesInicial;


    @Column(name = "meses_final")
    private int mesesFinal;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMesesInicial() {
        return mesesInicial;
    }

    public void setMesesInicial(int mesesInicial) {
        this.mesesInicial = mesesInicial;
    }

    public int getMesesFinal() {
        return mesesFinal;
    }

    public void setMesesFinal(int mesesFinal) {
        this.mesesFinal = mesesFinal;
    }
}
