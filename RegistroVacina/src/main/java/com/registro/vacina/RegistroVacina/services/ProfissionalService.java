package com.registro.vacina.RegistroVacina.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.registro.vacina.RegistroVacina.dto.ProfissionalDTO;
import com.registro.vacina.RegistroVacina.repositories.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public ProfissionalDTO autenticarProfissional(String cpf, String senha) {
        return profissionalRepository.findByCpf(cpf)
                .filter(profissional -> profissional.getSenha().equals(senha))
                .map(profissional -> {
                    ProfissionalDTO dto = new ProfissionalDTO();
                    dto.setNome(profissional.getNome());
                    dto.setDataNascimento(profissional.getDataNascimento());
                    dto.setCpf(profissional.getCpf());
                    dto.setCargoId(profissional.getCargoId());
                    return dto;
                })
                .orElseThrow(() -> new RuntimeException("CPF ou senha inválidos"));
    }
}

