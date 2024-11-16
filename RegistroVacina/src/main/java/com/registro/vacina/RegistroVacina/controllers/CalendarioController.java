package com.registro.vacina.RegistroVacina.controllers;

import com.registro.vacina.RegistroVacina.dto.CalendarioDto;
import com.registro.vacina.RegistroVacina.services.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  //Dizendo para SpringBoot que essa é uma Classe diferente das demais
@RequestMapping("api/calendario")
/** RequestMapping é uma  mapeamento de endPoints (Pahf) www.api.com.br endPoint base | direcionamento de Rotas
 www.api.com.br/api/calendario/'metodo'vacinacao  **/

public class CalendarioController {
    @Autowired
    private CalendarioService calendarioService;

    @GetMapping("/vacinacao")
    public List<CalendarioDto> consultaCalendario(@RequestParam int idade) { // Visbilidade/Retorno/nome/(parametros)/{}

        return calendarioService.buscarCalendario(idade);
    }
}
