package com.registro.vacina.RegistroVacina.components;

import com.registro.vacina.RegistroVacina.entities.HistoricoVacinacao;
import com.registro.vacina.RegistroVacina.entities.Paciente;
import com.registro.vacina.RegistroVacina.repositories.HistoricoVacinacaoRepository;
import com.registro.vacina.RegistroVacina.repositories.PacienteRepository;
import com.registro.vacina.RegistroVacina.services.LembreteService;
import com.registro.vacina.RegistroVacina.services.envioNotificacao.EmailNotificationSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@EnableScheduling
public class LembreteVacinaSchedulerTest {

    @Autowired
    private LembreteVacinaScheduler lembreteVacinaScheduler;

    @MockBean
    private LembreteService lembreteVacinaService;

    @MockBean
    private PacienteRepository pacienteRepository;

    @MockBean
    private HistoricoVacinacaoRepository historicoVacinacaoRepository;

    @MockBean
    private EmailNotificationSender emailNotificationSender;

    @Test
    public void testAgendarEnvioLembretes_VacinasPendentes_EnviaLembrete() {
        // Criar um paciente com vacinas pendentes
        Paciente paciente = new Paciente();
        paciente.setId(1);
        paciente.seteMail("paciente@example.com");
        paciente.setTipoComunicacao("email");

        List<Paciente> pacientes = Collections.singletonList(paciente); // Lista com um paciente
        when(pacienteRepository.findAll()).thenReturn(pacientes); // Retorna esse paciente quando a consulta for feita

        // Criar um histórico de vacinação com vacinas pendentes
        HistoricoVacinacao historicoVacinacao = new HistoricoVacinacao();
        historicoVacinacao.setPacienteId(paciente.getId());
        historicoVacinacao.setVacina(1);
        historicoVacinacao.setDose(1);
        historicoVacinacao.setAnoVencimento(new Date(System.currentTimeMillis() - 1000000));

        List<HistoricoVacinacao> historicoVacinacaoList = Collections.singletonList(historicoVacinacao);
        when(historicoVacinacaoRepository.findByPacienteId(paciente.getId()))
                .thenReturn(historicoVacinacaoList);

        // Executa o método de envio de lembretes manualmente
        lembreteVacinaScheduler.agendarEnvioLembretes();

        // Verifica se o serviço de envio de lembretes foi chamado
        verify(lembreteVacinaService, times(1)).enviarLembretes();
    }
}
