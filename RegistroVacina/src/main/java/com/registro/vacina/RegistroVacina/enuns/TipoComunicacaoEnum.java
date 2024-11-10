package com.registro.vacina.RegistroVacina.enuns;

public enum TipoComunicacaoEnum {

    EMAIL("assunto", "body"),
    SMS("assunto", "body"),
    TELEFONE("assunto", "body");

    TipoComunicacaoEnum(String assunto, String corpo) {
    }
}
