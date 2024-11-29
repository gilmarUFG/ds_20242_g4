package com.registro.vacina.RegistroVacina.Services;

import com.registro.vacina.RegistroVacina.dto.HistoricoVacinacaoDTO;
import com.registro.vacina.RegistroVacina.entities.Doses;
import com.registro.vacina.RegistroVacina.entities.HistoricoVacinacao;
import com.registro.vacina.RegistroVacina.entities.Vacina;
import com.registro.vacina.RegistroVacina.repositories.HistoricoVacinacaoRepository;
import com.registro.vacina.RegistroVacina.services.DoseService;
import com.registro.vacina.RegistroVacina.services.HistoricoVacinacaoService;
import com.registro.vacina.RegistroVacina.services.VacinaService;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@SpringBootTest
class HistoricoVacinacaoServiceTest {

    @Autowired
    private HistoricoVacinacaoService historicoVacinacaoService;

    @MockBean
    private HistoricoVacinacaoRepository historicoVacinacaoRepository;

    @MockBean
    private DoseService doseService;

    @MockBean
    private VacinaService vacinaService;

    // ---------- Testes referentes a filtragem das vacinas no histórico ---------- //
    @Test
    void buscarHistoricoVacinacao_FiltroPorNomeVacina_RetornaHistoricoFiltrado() {
        // Arrange
        int pacienteId = 1;
        String nomeVacina = "Vacina A";
        String dataVacinacao = null;

        HistoricoVacinacao historico1 = criarHistorico(1, pacienteId, "Lote1", new Date(), 2025, 1, 1);
        List<HistoricoVacinacao> historicos = List.of(historico1);

        Mockito.when(historicoVacinacaoRepository.findByPacienteId(pacienteId)).thenReturn(historicos);

        Vacina vacina = new Vacina();
        vacina.setNomeVacina("Vacina A");
        Mockito.when(vacinaService.buscarVacina(1)).thenReturn(vacina);

        Doses dose = new Doses();
        dose.setQuatidadeDose("2");
        Mockito.when(doseService.buscarDosesId(1)).thenReturn(dose);

        // Act
        List<HistoricoVacinacaoDTO> result = historicoVacinacaoService.buscarHistoricoVacinacao(pacienteId, nomeVacina, dataVacinacao);

        // Assert
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Vacina A", result.get(0).getNomeVacina());
    }

    @Test
    void buscarHistoricoVacinacao_FiltroPorDataDeVacinacao_RetornaHistoricoFiltrado() {
        // Arrange
        int pacienteId = 1;
        String nomeVacina = null;
        String dataVacinacao = "01/01/2023";

        Date dataHistorico = new GregorianCalendar(2023, Calendar.JANUARY, 1).getTime();
        HistoricoVacinacao historico1 = criarHistorico(1, pacienteId, "Lote1", dataHistorico, 2025, 1, 1);
        List<HistoricoVacinacao> historicos = List.of(historico1);

        Mockito.when(historicoVacinacaoRepository.findByPacienteId(pacienteId)).thenReturn(historicos);

        Vacina vacina = new Vacina();
        vacina.setNomeVacina("Vacina A");
        Mockito.when(vacinaService.buscarVacina(1)).thenReturn(vacina);

        Doses dose = new Doses();
        dose.setQuatidadeDose("2");
        Mockito.when(doseService.buscarDosesId(1)).thenReturn(dose);

        // Act
        List<HistoricoVacinacaoDTO> result = historicoVacinacaoService.buscarHistoricoVacinacao(pacienteId, nomeVacina, dataVacinacao);

        // Assert
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(dataHistorico, result.get(0).getDataVacinacao());
    }

    @Test
    void buscarHistoricoVacinacao_NenhumaVacinaNoFiltro_RetornaListaVazia() {
        // Arrange
        int pacienteId = 1;
        String nomeVacina = "Vacina B";
        String dataVacinacao = null;

        HistoricoVacinacao historico1 = criarHistorico(1, pacienteId, "Lote1", new Date(), 2025, 1, 1);
        List<HistoricoVacinacao> historicos = List.of(historico1);

        Mockito.when(historicoVacinacaoRepository.findByPacienteId(pacienteId)).thenReturn(historicos);

        Vacina vacina = new Vacina();
        vacina.setNomeVacina("Vacina A");
        Mockito.when(vacinaService.buscarVacina(1)).thenReturn(vacina);

        // Act
        List<HistoricoVacinacaoDTO> result = historicoVacinacaoService.buscarHistoricoVacinacao(pacienteId, nomeVacina, dataVacinacao);

        // Assert
        Assertions.assertTrue(result.isEmpty());
    }

    private @NotNull HistoricoVacinacao criarHistorico(int id, int pacienteId, String lote, Date dataVacinacao, int anoVencimento, int dose, int vacina) {
        HistoricoVacinacao historico = new HistoricoVacinacao();
        historico.setId(id);
        historico.setPacienteId(pacienteId);
        historico.setLoteVacinacao(lote);
        historico.setDataVacinacao(dataVacinacao);
        historico.setAnoVencimento(new GregorianCalendar(anoVencimento, Calendar.JANUARY, 1).getTime());
        historico.setDose(dose);
        historico.setVacina(vacina);
        return historico;
    }
}
