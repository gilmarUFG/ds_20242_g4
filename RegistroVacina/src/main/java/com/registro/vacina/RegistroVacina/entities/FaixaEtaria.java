package com.registro.vacina.RegistroVacina.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "faixaetaria")
public class FaixaEtaria {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "meses_inicial")
    private int mesesInicial;

    @Id
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
