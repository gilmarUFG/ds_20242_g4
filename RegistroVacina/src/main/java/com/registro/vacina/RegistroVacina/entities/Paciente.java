package com.registro.vacina.RegistroVacina.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {

   @Id
   @Column(name = "id")
   private int id;

   @Column (name = "nome")
   private char nome;

   @Column (name = "cpf")
   private int cpf;

   @Column (name = "cartaoSUS")
   private int cartaoSUS;

   @Column (name = "tipoComunicacao")
   private  String tipoComunicacao;

   @Column (name = "numTelefone")
   private char numTelefone;

   @Column (name = "eMail")
   private char eMail;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public char getNome() {
      return nome;
   }

   public void setNome(char nome) {
      this.nome = nome;
   }

   public int getCpf() {
      return cpf;
   }

   public void setCpf(int cpf) {
      this.cpf = cpf;
   }

   public int getCartaoSUS() {
      return cartaoSUS;
   }

   public void setCartaoSUS(int cartaoSUS) {
      this.cartaoSUS = cartaoSUS;
   }

   public String getTipoComunicacao() {
      return tipoComunicacao;
   }

   public void setTipoComunicacao(String tipoComunicacao) {
      this.tipoComunicacao = tipoComunicacao;
   }

   public char getNumTelefone() {
      return numTelefone;
   }

   public void setNumTelefone(char numTelefone) {
      this.numTelefone = numTelefone;
   }

   public char geteMail() {
      return eMail;
   }

   public void seteMail(char eMail) {
      this.eMail = eMail;
   }
}
