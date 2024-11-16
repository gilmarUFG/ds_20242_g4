package com.registro.vacina.RegistroVacina.services;

import com.registro.vacina.RegistroVacina.entities.HistoricoVacinacao;
import com.registro.vacina.RegistroVacina.entities.Paciente;
import com.registro.vacina.RegistroVacina.entities.Vacina;
import com.registro.vacina.RegistroVacina.repositories.HistoricoVacinacaoRepository;
import com.registro.vacina.RegistroVacina.repositories.PacienteRepository;
import com.registro.vacina.RegistroVacina.repositories.VacinaRepository;
import com.registro.vacina.RegistroVacina.services.envioNotificacao.AppNotificationSender;
import com.registro.vacina.RegistroVacina.services.envioNotificacao.EmailNotificationSender;
import com.registro.vacina.RegistroVacina.services.envioNotificacao.SMSNotificationSender;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LembreteService {

    @Autowired
    private EmailNotificationSender emailNotificationSender;
    @Autowired
    private SMSNotificationSender smsNotificationSender;
    @Autowired
    private AppNotificationSender appNotificationSender;
    @Autowired
    public PacienteRepository pacienteRepository;
    @Autowired
    public VacinaRepository vacinaRepository;
    @Autowired
    public HistoricoVacinacaoRepository historicoVacinacaoRepository;

    public void enviarLembretes() {
        List<Paciente> pacientes = pacienteRepository.findAll();

        for(Paciente paciente : pacientes) {
            List<HistoricoVacinacao> historico = historicoVacinacaoRepository.findByPacienteId(paciente.getId());
            List<String> vacinasPendentes = new ArrayList<>();
            List<Vacina> vacinasDisponiveis = vacinaRepository.findAll();

            for(Vacina vacina : vacinasDisponiveis) {
                boolean vacinaTomada = false;
                for(HistoricoVacinacao h : historico) {
                    if(h.getVacina() == vacina.getId() && h.getDose() >= 3) {
                        vacinaTomada = true; // O paciente tomou todas as doses da vacina
                        break;
                    }
                }

                if(!vacinaTomada) {
                    vacinasPendentes.add(vacina.getNomeVacina());
                }
            }

            if(!vacinasPendentes.isEmpty()) {
                String mensagem = "Você tem vacinas pendentes: " + String.join(", ", vacinasPendentes);
                enviarLembrete(paciente, mensagem); // Envia o lembrete para o paciente
            }
        }
    }

    private void enviarLembrete(@NotNull Paciente paciente, String mensagem) {
        switch(paciente.getTipoComunicacao()) {
            case "email":
                emailNotificationSender.send(paciente.geteMail(), mensagem);
                break;
            case "sms":
                smsNotificationSender.send(paciente.getNumTelefone(), mensagem);
                break;
            case "app":
                appNotificationSender.send(paciente.getCartaoSUS(), mensagem);
                break;
            default:
                throw new IllegalArgumentException("Tipo de comunicação inválido.");
        }
    }
}
