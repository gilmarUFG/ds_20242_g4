package com.registro.vacina.RegistroVacina.components;

import com.registro.vacina.RegistroVacina.entities.HistoricoVacinacao;
import com.registro.vacina.RegistroVacina.entities.Paciente;
import com.registro.vacina.RegistroVacina.repositories.HistoricoVacinacaoRepository;
import com.registro.vacina.RegistroVacina.repositories.PacienteRepository;
import com.registro.vacina.RegistroVacina.services.LembreteService;
import com.registro.vacina.RegistroVacina.services.envioNotificacao.EmailNotificationSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@EnableScheduling // Ativa o agendamento no contexto de testes
public class LembreteVacinaSchedulerTest {

    @Autowired
    private LembreteVacinaScheduler lembreteVacinaScheduler;

    @MockBean
    private LembreteService lembreteVacinaService; // Mock do serviço responsável por enviar os lembretes

    @MockBean
    private PacienteRepository pacienteRepository; // Mock do repositório de pacientes

    @MockBean
    private HistoricoVacinacaoRepository historicoVacinacaoRepository; // Mock do repositório de histórico de vacinação

    @MockBean
    private EmailNotificationSender emailNotificationSender; // Mock do serviço de envio de email

    @Test
    public void testAgendarEnvioLembretes_VacinasPendentes_EnviaLembrete() {
        // Criar um paciente com vacinas pendentes
        Paciente paciente = new Paciente();
        paciente.setId(1);
        paciente.seteMail("paciente@example.com");
        paciente.setTipoComunicacao("email"); // O paciente prefere receber lembretes por e-mail

        List<Paciente> pacientes = Collections.singletonList(paciente); // Lista com um paciente
        when(pacienteRepository.findAll()).thenReturn(pacientes); // Retorna esse paciente quando a consulta for feita

        // Criar um histórico de vacinação com vacinas pendentes
        HistoricoVacinacao historicoVacinacao = new HistoricoVacinacao();
        historicoVacinacao.setPacienteId(paciente.getId());
        historicoVacinacao.setVacina(1); // ID da vacina
        historicoVacinacao.setDose(1); // Primeira dose pendente
        historicoVacinacao.setAnoVencimento(new Date(System.currentTimeMillis() - 1000000)); // Vacina vencida

        List<HistoricoVacinacao> historicoVacinacaoList = Collections.singletonList(historicoVacinacao);
        when(historicoVacinacaoRepository.findByPacienteId(paciente.getId()))
                .thenReturn(historicoVacinacaoList); // Retorna esse histórico para o paciente

        // Executa o método de envio de lembretes manualmente
        lembreteVacinaScheduler.agendarEnvioLembretes();

        // Verifica se o serviço de envio de lembretes foi chamado
        verify(lembreteVacinaService, times(1)).enviarLembretes(); // O serviço de lembretes deve ter sido chamado uma vez
    }
}
