package com.registro.vacina.RegistroVacina.controllers;

import com.registro.vacina.RegistroVacina.dto.HistoricoVacinacaoDTO;
import com.registro.vacina.RegistroVacina.services.HistoricoVacinacaoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HistoricoVacinacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HistoricoVacinacaoService historicoVacinacaoService;

    @Test
    public void consultaHistoricoVacinacao_SemFiltros_RetornarListaComResultados() throws Exception {
        // Mock dos dados de retorno
        HistoricoVacinacaoDTO dto = new HistoricoVacinacaoDTO();
        dto.setDataVacinacao(new SimpleDateFormat("dd/MM/yyyy").parse("10/11/2023"));
        dto.setAnoVencimneto(new SimpleDateFormat("yyyy").parse("2024"));
        dto.setLoteVacinacao("12345");
        dto.setQuantidadeDoses("1");
        dto.setNomeVacina("Vacina Teste");

        List<HistoricoVacinacaoDTO> mockResponse = Arrays.asList(dto);

        Mockito.when(historicoVacinacaoService.buscarHistoricoVacinacao(1, null, null))
                .thenReturn(mockResponse);

        mockMvc.perform(get("/api/historico")
                        .param("pacienteId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nomeVacina")
                        .value("Vacina Teste"))
                .andExpect(jsonPath("$[0].loteVacinacao")
                        .value("12345"))
                .andExpect(jsonPath("$[0].quantidadeDoses")
                        .value("1"))
                .andExpect(jsonPath("$[0].dataVacinacao")
                        .value("10/11/2023"));
    }

    @Test
    public void consultaHistoricoVacinacao_ComFiltroNomeVacina_RetornarResultadosFiltrados() throws Exception {
        // Mock dos dados de retorno
        HistoricoVacinacaoDTO dto = new HistoricoVacinacaoDTO();
        dto.setDataVacinacao(new SimpleDateFormat("dd/MM/yyyy").parse("10/11/2023"));
        dto.setAnoVencimneto(new SimpleDateFormat("yyyy").parse("2024"));
        dto.setLoteVacinacao("12345");
        dto.setQuantidadeDoses("1");
        dto.setNomeVacina("Vacina Filtrada");

        List<HistoricoVacinacaoDTO> mockResponse = Arrays.asList(dto);

        Mockito.when(historicoVacinacaoService.buscarHistoricoVacinacao(1, "Vacina Filtrada", null))
                .thenReturn(mockResponse);

        mockMvc.perform(get("/api/historico")
                        .param("pacienteId", "1")
                        .param("nomeVacina", "Vacina Filtrada"))
                .andExpect(status().isOk()).andExpect(jsonPath("$[0].nomeVacina")
                        .value("Vacina Filtrada"));
    }

    @Test
    public void consultaHistoricoVacinacao_SemResultados_RetornarListaVazia() throws Exception {
        Mockito.when(historicoVacinacaoService.buscarHistoricoVacinacao(1, null, null))
                .thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/historico").param("pacienteId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$")
                        .isEmpty());
    }
}
