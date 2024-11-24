package com.registro.vacina.RegistroVacina.services;

import com.registro.vacina.RegistroVacina.dto.ConfirmacaoLembreteDTO;
import com.registro.vacina.RegistroVacina.entities.ConfirmacaoLembrete;
import com.registro.vacina.RegistroVacina.repositories.ConfirmacaoLembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ConfirmacaoLembreteService {

    @Autowired
    private ConfirmacaoLembreteRepository confirmacaoLembreteRepository;

    public List<ConfirmacaoLembrete> buscarTodos() {
        return confirmacaoLembreteRepository.findAll();
    }

    public Optional<ConfirmacaoLembrete> buscarPorId(Integer id) {
        return confirmacaoLembreteRepository.findById(id);
    }

    public ConfirmacaoLembrete criarConfirmacao(ConfirmacaoLembreteDTO confirmacaoLembreteDTO) {
        ConfirmacaoLembrete confirmacaoLembrete = new ConfirmacaoLembrete();
        confirmacaoLembrete.setLembreteId(confirmacaoLembreteDTO.getLembreteId());
        confirmacaoLembrete.setUsuario(confirmacaoLembreteDTO.getUsuario());
        confirmacaoLembrete.setDataConfirmacao(LocalDateTime.now()); // Define a data de confirmação como o momento atual
        return confirmacaoLembreteRepository.save(confirmacaoLembrete);
    }

    public ConfirmacaoLembrete atualizarConfirmacao(Integer id, ConfirmacaoLembreteDTO confirmacaoAtualizadaDTO) {
        Optional<ConfirmacaoLembrete> confirmacaoExistente = confirmacaoLembreteRepository.findById(id);
        if (confirmacaoExistente.isPresent()) {
            ConfirmacaoLembrete confirmacao = confirmacaoExistente.get();
            confirmacao.setLembreteId(confirmacaoAtualizadaDTO.getLembreteId());
            confirmacao.setUsuario(confirmacaoAtualizadaDTO.getUsuario());
            confirmacao.setDataConfirmacao(
                    confirmacaoAtualizadaDTO.getDataConfirmacao() != null ?
                            LocalDateTime.parse(confirmacaoAtualizadaDTO.getDataConfirmacao()) : confirmacao.getDataConfirmacao());
            return confirmacaoLembreteRepository.save(confirmacao);
        } else {
            throw new RuntimeException("Confirmação não encontrada com ID: " + id);
        }
    }

    public void deletarConfirmacao(Integer id) {
        confirmacaoLembreteRepository.deleteById(id);
    }
}
