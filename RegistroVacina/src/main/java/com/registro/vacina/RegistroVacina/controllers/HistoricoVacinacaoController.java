package com.registro.vacina.RegistroVacina.controllers;


import com.registro.vacina.RegistroVacina.dto.HistoricoVacinacaoDTO;
import com.registro.vacina.RegistroVacina.services.HistoricoVacinacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class HistoricoVacinacaoController {

    @Autowired
    private HistoricoVacinacaoService historicoVacinacaoService;


    @GetMapping("/historico")
    public List<HistoricoVacinacaoDTO> consultaHistoricoVacinacao(@RequestParam int pacienteId, @RequestParam(required = false) String nomeVacina, @RequestParam(required = false)  String dataVacinacao) {
        return historicoVacinacaoService.buscarHistoricoVacinacao(pacienteId, nomeVacina, dataVacinacao);

    }

    @GetMapping("historico/por-cpf")
    public ResponseEntity<?> consultarHistoricoPorCpf(@RequestParam String cpf) {
        try {
            List<HistoricoVacinacaoDTO> historico = historicoVacinacaoService.buscarHistoricoPorCpf(cpf);
            return ResponseEntity.ok(historico);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Erro ao consultar histórico: " + e.getMessage());
        }
    }
}
