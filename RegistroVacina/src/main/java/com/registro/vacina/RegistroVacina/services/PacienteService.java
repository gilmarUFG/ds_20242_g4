package com.registro.vacina.RegistroVacina.services;


import com.registro.vacina.RegistroVacina.entities.Paciente;
import com.registro.vacina.RegistroVacina.enuns.TipoComunicacaoEnum;
import com.registro.vacina.RegistroVacina.repositories.PacienteRepository;
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

    public void enviarNotificacao(Paciente paciente) {
        if (paciente.getTipoComunicacao().equals(TipoComunicacaoEnum.EMAIL)) {
            //Regra
        } else if (paciente.getTipoComunicacao().equals(TipoComunicacaoEnum.TELEFONE)){
            //Regra
        } else if (paciente.getTipoComunicacao().equals(TipoComunicacaoEnum.SMS)) {
            //Regra
        }

    }
}
