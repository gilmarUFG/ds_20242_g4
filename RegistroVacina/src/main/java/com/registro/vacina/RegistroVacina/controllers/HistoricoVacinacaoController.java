package com.registro.vacina.RegistroVacina.controllers;


import com.registro.vacina.RegistroVacina.dto.HistoricoVacinacaoDTO;
import com.registro.vacina.RegistroVacina.entities.HistoricoVacinacao;
import com.registro.vacina.RegistroVacina.services.HistoricoVacinacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class HistoricoVacinacaoController {

    @Autowired
    private HistoricoVacinacaoService historicoVacinacaoService;


    @GetMapping("/historico")
    public List<HistoricoVacinacaoDTO> consultaGistoricoVacinacao(@RequestParam int pacienteId) {
        return historicoVacinacaoService.buscarHistoricoVacinacao(pacienteId);



//        List<HistoricoVacinacaoDTO> historicoDTO = new ArrayList<>();
//
//        for(HistoricoVacinacao h : historico){
//            HistoricoVacinacaoDTO historicoVacinacaoDTO = new HistoricoVacinacaoDTO();
//            historicoVacinacaoDTO.setDataVacinacao(h.getDataVacinacao());
//            historicoVacinacaoDTO.setLoteVacinacao(h.getLoteVacinacao());
//            historicoVacinacaoDTO.setAnoVencimneto(h.getAnoVencimento());
//
//            historicoDTO.add(historicoVacinacaoDTO);
//        }
//
//
//        return historicoDTO;
//    }


    }
}
