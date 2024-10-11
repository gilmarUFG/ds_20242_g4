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
    private int quatidadeDose;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuatidadeDose() {
        return quatidadeDose;
    }

    public void setQuatidadeDose(int quatidadeDose) {
        this.quatidadeDose = quatidadeDose;
    }
}
