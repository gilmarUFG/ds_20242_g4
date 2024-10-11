package com.registro.vacina.RegistroVacina.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "calendario")
public class Calendario
{
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "categoria_id")
    private int categoriId;

    @Column(name = "dose_id")
    private int doseId;

    @Column(name = "faixaetaria_id")
    private  int faixaEtariaId;


    @Column(name = "vacina_id")
    private int vacinaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoriId() {
        return categoriId;
    }

    public void setCategoriId(int categoriId) {
        this.categoriId = categoriId;
    }

    public int getDoseId() {
        return doseId;
    }

    public void setDoseId(int doseId) {
        this.doseId = doseId;
    }

    public int getFaixaEtariaId() {
        return faixaEtariaId;
    }

    public void setFaixaEtariaId(int faixaEtariaId) {
        this.faixaEtariaId = faixaEtariaId;
    }

    public int getVacinaId() {
        return vacinaId;
    }

    public void setVacinaId(int vacinaId) {
        this.vacinaId = vacinaId;
    }
}
