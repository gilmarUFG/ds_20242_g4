package com.registro.vacina.RegistroVacina.controllers;


import com.registro.vacina.RegistroVacina.dto.HistoricoVacinacaoDTO;
import com.registro.vacina.RegistroVacina.services.HistoricoVacinacaoService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
