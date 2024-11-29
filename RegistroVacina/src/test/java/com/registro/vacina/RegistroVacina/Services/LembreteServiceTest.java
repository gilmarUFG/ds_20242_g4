package com.registro.vacina.RegistroVacina.Services;

import com.registro.vacina.RegistroVacina.entities.HistoricoVacinacao;
import com.registro.vacina.RegistroVacina.entities.Paciente;
import com.registro.vacina.RegistroVacina.entities.Vacina;
import com.registro.vacina.RegistroVacina.repositories.HistoricoVacinacaoRepository;
import com.registro.vacina.RegistroVacina.repositories.PacienteRepository;
import com.registro.vacina.RegistroVacina.repositories.VacinaRepository;
import com.registro.vacina.RegistroVacina.services.LembreteService;
import com.registro.vacina.RegistroVacina.services.envioNotificacao.AppNotificationSender;
import com.registro.vacina.RegistroVacina.services.envioNotificacao.EmailNotificationSender;
import com.registro.vacina.RegistroVacina.services.envioNotificacao.SMSNotificationSender;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
class LembreteServiceTest {

    @Autowired
    private LembreteService lembreteService;

    @MockBean
    private PacienteRepository pacienteRepository;

    @MockBean
    private VacinaRepository vacinaRepository;

    @MockBean
    private HistoricoVacinacaoRepository historicoVacinacaoRepository;

    @MockBean
    private EmailNotificationSender emailNotificationSender;

    @MockBean
    private SMSNotificationSender smsNotificationSender;

    @MockBean
    private AppNotificationSender appNotificationSender;

    @Test
    void enviarLembrete_MeioDeComunicacaoEmail_EnviarLembretesEmail() {
        // Arrange
        Paciente paciente = new Paciente();
        paciente.setId(1);
        paciente.setNome("João");
        paciente.setTipoComunicacao("email");
        paciente.seteMail("joao@email.com");

        Vacina vacina = new Vacina();
        vacina.setId(1);
        vacina.setNomeVacina("Hepatite B");

        List<Paciente> pacientes = List.of(paciente);
        List<Vacina> vacinas = List.of(vacina);
        List<HistoricoVacinacao> historico = List.of();

        Mockito.when(pacienteRepository.findAll()).thenReturn(pacientes);
        Mockito.when(vacinaRepository.findAll()).thenReturn(vacinas);
        Mockito.when(historicoVacinacaoRepository.findByPacienteId(1)).thenReturn(historico);

        // Act
        lembreteService.enviarLembretes();

        // Assert
        Mockito.verify(emailNotificationSender, Mockito.times(1))
                .send(Mockito.eq("joao@email.com"), Mockito.contains("Hepatite B"));
    }

    @Test
    void enviarLembrete_MeioDeComunicacaoSMS_EnviarLembretesSMS() {
        //Arrange
        Paciente paciente = new Paciente();
        paciente.setId(2);
        paciente.setNome("Maria");
        paciente.setTipoComunicacao("sms");
        paciente.setNumTelefone("11999999999");

        Vacina vacina = new Vacina();
        vacina.setId(2);
        vacina.setNomeVacina("Gripe");

        List<Paciente> pacientes = List.of(paciente);
        List<Vacina> vacinas = List.of(vacina);
        List<HistoricoVacinacao> historico = List.of();

        Mockito.when(pacienteRepository.findAll()).thenReturn(pacientes);
        Mockito.when(vacinaRepository.findAll()).thenReturn(vacinas);
        Mockito.when(historicoVacinacaoRepository.findByPacienteId(2)).thenReturn(historico);

        // Act
        lembreteService.enviarLembretes();

        // Assert
        Mockito.verify(smsNotificationSender, Mockito.times(1))
                .send(Mockito.eq("11999999999"), Mockito.contains("Gripe"));
    }

    @Test
    void enviarLembrete_MeioDeComunicacaoApp_EnviarLembretesApp() {
        // Arrange
        Paciente paciente = new Paciente();
        paciente.setId(3);
        paciente.setNome("Carlos");
        paciente.setTipoComunicacao("app");
        paciente.setCartaoSUS("123456789");

        Vacina vacina = new Vacina();
        vacina.setId(3);
        vacina.setNomeVacina("COVID-19");

        List<Paciente> pacientes = List.of(paciente);
        List<Vacina> vacinas = List.of(vacina);
        List<HistoricoVacinacao> historico = List.of();

        Mockito.when(pacienteRepository.findAll()).thenReturn(pacientes);
        Mockito.when(vacinaRepository.findAll()).thenReturn(vacinas);
        Mockito.when(historicoVacinacaoRepository.findByPacienteId(3)).thenReturn(historico);

        // Act
        lembreteService.enviarLembretes();

        // Assert
        Mockito.verify(appNotificationSender, Mockito.times(1))
                .send(Mockito.eq("123456789"), Mockito.contains("COVID-19"));
    }

    @Test
    void enviarLembrete_SemVacinasPendentes_NaoEnviaNotificacao() {
        // Arrange
        Paciente paciente = new Paciente();
        paciente.setId(4);
        paciente.setNome("Ana");
        paciente.setTipoComunicacao("email");
        paciente.seteMail("ana@email.com");

        Vacina vacina = new Vacina();
        vacina.setId(4);
        vacina.setNomeVacina("Sarampo");

        HistoricoVacinacao historico = new HistoricoVacinacao();
        historico.setPacienteId(4);
        historico.setVacina(4);
        historico.setDose(3); // Todas as doses completas

        List<Paciente> pacientes = List.of(paciente);
        List<Vacina> vacinas = List.of(vacina);
        List<HistoricoVacinacao> historicoList = List.of(historico);

        Mockito.when(pacienteRepository.findAll()).thenReturn(pacientes);
        Mockito.when(vacinaRepository.findAll()).thenReturn(vacinas);
        Mockito.when(historicoVacinacaoRepository.findByPacienteId(4)).thenReturn(historicoList);

        // Act
        lembreteService.enviarLembretes();

        // Assert
        Mockito.verify(emailNotificationSender, Mockito.never()).send(Mockito.anyString(), Mockito.anyString());
        Mockito.verify(smsNotificationSender, Mockito.never()).send(Mockito.anyString(), Mockito.anyString());
        Mockito.verify(appNotificationSender, Mockito.never()).send(Mockito.anyString(), Mockito.anyString());
    }
}
