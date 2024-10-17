package com.registro.vacina.RegistroVacina.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doses")
public class Doses {

    @Id
    @Column( name= "id")
    private int id;

    @Column(name = "quantidade_dose")
    private String quatidadeDose;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuatidadeDose() {
        return this.quatidadeDose;
    }

    public void setQuatidadeDose(String quatidadeDose) {
        this.quatidadeDose = quatidadeDose;
    }
}
