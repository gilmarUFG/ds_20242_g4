package com.registro.vacina.RegistroVacina.dto;

import java.time.LocalDate;

public class ProfissionalDTO {
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private int cargoId;
    private String senha;

    public ProfissionalDTO() {
    }

    public ProfissionalDTO(String nome, LocalDate dataNascimento, String cpf, int cargoId, String senha) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.cargoId = cargoId;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}