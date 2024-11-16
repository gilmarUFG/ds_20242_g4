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
   private String nome;

   @Column (name = "cpf")
   private String cpf;

   @Column (name = "cartaoSUS")
   private String cartaoSUS;

   @Column (name = "tipoComunicacao")
   private  String tipoComunicacao;

   @Column (name = "numTelefone")
   private String numTelefone;

   @Column (name = "eMail")
   private String eMail;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getCpf() {
      return cpf;
   }

   public void setCpf(String cpf) {
      this.cpf = cpf;
   }

   public String getCartaoSUS() {
      return cartaoSUS;
   }

   public void setCartaoSUS(String cartaoSUS) {
      this.cartaoSUS = cartaoSUS;
   }

   public String getTipoComunicacao() {
      return tipoComunicacao;
   }

   public void setTipoComunicacao(String tipoComunicacao) {
      this.tipoComunicacao = tipoComunicacao;
   }

   public String getNumTelefone() {
      return numTelefone;
   }

   public void setNumTelefone(String numTelefone) {
      this.numTelefone = numTelefone;
   }

   public String geteMail() {
      return eMail;
   }

   public void seteMail(String eMail) {
      this.eMail = eMail;
   }
}
