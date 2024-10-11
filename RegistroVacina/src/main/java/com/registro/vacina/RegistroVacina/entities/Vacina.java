package com.registro.vacina.RegistroVacina.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="vacinas")
public class Vacina
{
    @Id
    @Column(name = "id")
    private int id;


    @Column(name = "nome_vacina")
    private String nomeVacina;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }
}
