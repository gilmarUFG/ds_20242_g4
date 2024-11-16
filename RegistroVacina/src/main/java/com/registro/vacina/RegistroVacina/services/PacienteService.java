package com.registro.vacina.RegistroVacina.services;


import com.registro.vacina.RegistroVacina.entities.Paciente;
import com.registro.vacina.RegistroVacina.enuns.TipoComunicacaoEnum;
import com.registro.vacina.RegistroVacina.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente buscarPaciente(int id)
    {
        Optional<Paciente> retorno = pacienteRepository.findById(id);
        return  retorno.get();
    }

    public void setPreferenciaComunicacao(int id, TipoComunicacaoEnum tipoComunicacao) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        if (pacienteOptional.isPresent()) {
            Paciente paciente = pacienteOptional.get();
            // Usa o enum diretamente para definir o tipo de comunicação
            paciente.setTipoComunicacao(tipoComunicacao.name());
            pacienteRepository.save(paciente);
        } else {
            throw new EntityNotFoundException("Paciente com ID " + id + " não encontrado.");
        }
    }
}
