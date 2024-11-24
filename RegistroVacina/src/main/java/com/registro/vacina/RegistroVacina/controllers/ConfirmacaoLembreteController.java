package com.registro.vacina.RegistroVacina.controllers;

import com.registro.vacina.RegistroVacina.dto.ConfirmacaoLembreteDTO;
import com.registro.vacina.RegistroVacina.entities.ConfirmacaoLembrete;
import com.registro.vacina.RegistroVacina.services.ConfirmacaoLembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/confirmacoes")
public class ConfirmacaoLembreteController {

    @Autowired
    private ConfirmacaoLembreteService confirmacaoLembreteService;

    @GetMapping
    public ResponseEntity<List<ConfirmacaoLembrete>> listarTodos() {
        List<ConfirmacaoLembrete> confirmacoes = confirmacaoLembreteService.buscarTodos();
        return ResponseEntity.ok(confirmacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfirmacaoLembrete> buscarPorId(@PathVariable Integer id) {
        return confirmacaoLembreteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ConfirmacaoLembrete> criar(@RequestBody ConfirmacaoLembreteDTO confirmacaoLembreteDTO) {
        ConfirmacaoLembrete novaConfirmacao = confirmacaoLembreteService.criarConfirmacao(confirmacaoLembreteDTO);
        return ResponseEntity.ok(novaConfirmacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConfirmacaoLembrete> atualizar(@PathVariable Integer id,
                                                         @RequestBody ConfirmacaoLembreteDTO confirmacaoAtualizadaDTO) {
        try {
            ConfirmacaoLembrete confirmacaoAtualizada = confirmacaoLembreteService.atualizarConfirmacao(id, confirmacaoAtualizadaDTO);
            return ResponseEntity.ok(confirmacaoAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        confirmacaoLembreteService.deletarConfirmacao(id);
        return ResponseEntity.noContent().build();
    }
}
