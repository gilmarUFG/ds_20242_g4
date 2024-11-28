package com.registro.vacina.RegistroVacina.controllers;


import com.registro.vacina.RegistroVacina.dto.LoginDTO;
import com.registro.vacina.RegistroVacina.request.LoginRequest;
import com.registro.vacina.RegistroVacina.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity autenticarLogin(@RequestBody LoginRequest loginRequest){

        if(loginService.validarLogin(loginRequest.getCpf()) != null)
        {
            return ResponseEntity.ok().body(loginService.validarLogin(loginRequest.getCpf()));
        }
        else
        {
            return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body("Falha no Login");
        }

    }

}
