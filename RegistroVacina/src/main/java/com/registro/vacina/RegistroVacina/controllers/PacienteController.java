package com.registro.vacina.RegistroVacina.controllers;

import com.registro.vacina.RegistroVacina.enuns.TipoComunicacaoEnum;
import com.registro.vacina.RegistroVacina.services.PacienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PutMapping("/{id}/comunicacao")
    public ResponseEntity<String> atualizarPreferenciaComunicacao(@PathVariable int id, @RequestParam String tipoComunicacao) {
        System.out.println("Recebido ID: " + id);
        System.out.println("Recebido Tipo de Comunicação: " + tipoComunicacao);
        try {
            if (!isTipoComunicacaoValido(tipoComunicacao)) {
                System.out.println("Tipo de comunicação inválido: " + tipoComunicacao);
                return ResponseEntity.badRequest().body("Opção inválida. Valores permitidos: EMAIL, SMS, TELEFONE.");
            }
            pacienteService.setPreferenciaComunicacao(id, TipoComunicacaoEnum.valueOf(tipoComunicacao.toUpperCase()));
            return ResponseEntity.ok("Preferência de comunicação atualizada com sucesso.");
        } catch (EntityNotFoundException e) {
            System.out.println("Paciente não encontrado: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace(); // Imprime o erro no log
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar preferência de comunicação.");
        }
    }

    // Valida se o tipo de comunicação está no enum
    private boolean isTipoComunicacaoValido(String tipoComunicacao) {
        try {
            TipoComunicacaoEnum.valueOf(tipoComunicacao.toUpperCase());
            return true;
        } catch(IllegalArgumentException e) {
            return false;
        }
    }
}

