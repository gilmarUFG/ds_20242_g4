package com.registro.vacina.RegistroVacina.services;


import com.registro.vacina.RegistroVacina.repositories.ConfirmacaoLembreteRepository;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.registro.vacina.RegistroVacina.entities.ConfirmacaoLembrete;
import com.registro.vacina.RegistroVacina.repositories.ConfirmacaoLembreteRepository;

@Service
public class ConfirmacaoLembreteService {

    private final ConfirmacaoLembreteRepository confirmacaoLembreteRepository;

    // Injeção de dependência via construtor
    public ConfirmacaoLembreteService(ConfirmacaoLembreteRepository confirmacaoLembreteRepository) {
        this.confirmacaoLembreteRepository = confirmacaoLembreteRepository;
    }

    // Método para confirmar o recebimento do lembrete
    public ConfirmacaoLembrete confirmarRecebimento(int lembreteId, int pacienteId) {
        // Validações de entrada
        Assert.isTrue(lembreteId > 0, "O ID do lembrete deve ser maior que zero.");
        Assert.isTrue(pacienteId > 0, "O ID do paciente deve ser maior que zero.");

        // Criação do objeto de confirmação
        ConfirmacaoLembrete confirmacao = new ConfirmacaoLembrete();
        confirmacao.setLembreteId(lembreteId);
        confirmacao.setPacienteId(pacienteId);
        confirmacao.setDataConfirmacao(LocalDateTime.now());

        // Salvando no repositório
        return confirmacaoLembreteRepository.save(confirmacao);
    }
}
