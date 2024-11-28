package com.registro.vacina.RegistroVacina.controllers;

import com.registro.vacina.RegistroVacina.dto.ProfissionalDTO;
import com.registro.vacina.RegistroVacina.services.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/profissionais")
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    @Autowired
    public ProfissionalController(ProfissionalService profissionalService) {
        this.profissionalService = profissionalService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> autenticarProfissional(@RequestBody ProfissionalDTO loginRequest) {
        try {
            ProfissionalDTO profissionalAutenticado = profissionalService.autenticarProfissional(
                    loginRequest.getCpf(), loginRequest.getSenha());
            return ResponseEntity.ok(profissionalAutenticado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Erro na autenticação: " + e.getMessage());
        }
    }
}