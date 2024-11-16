package com.registro.vacina.RegistroVacina.controllers;

import com.registro.vacina.RegistroVacina.dto.CalendarioDto;
import com.registro.vacina.RegistroVacina.services.CalendarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalendarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalendarioService calendarioService;

    @InjectMocks
    private CalendarioController calendarioController;

    private List<CalendarioDto> calendarioDtos;

    @BeforeEach
    void setUp() {
        calendarioDtos = new ArrayList<>();

        // Setup fake CalendarioDto objects for the test
        CalendarioDto calendarioDto1 = new CalendarioDto();
        calendarioDto1.setCalendarioId(1);
        calendarioDto1.setCategoria("Categoria 1");
        calendarioDto1.setDoses("2 doses");
        calendarioDto1.setVacinas("Vacina A");

        CalendarioDto calendarioDto2 = new CalendarioDto();
        calendarioDto2.setCalendarioId(2);
        calendarioDto2.setCategoria("Categoria 2");
        calendarioDto2.setDoses("1 dose");
        calendarioDto2.setVacinas("Vacina B");

        calendarioDtos.add(calendarioDto1);
        calendarioDtos.add(calendarioDto2);
    }

    @Test
    void consultaCalendario_DadosCorretos_RetornarCalendarios() throws Exception {
        // Mock the behavior of the CalendarioService
        when(calendarioService.buscarCalendario(30)).thenReturn(calendarioDtos);

        // Perform the GET request
        mockMvc.perform(get("/api/calendario/vacinacao")
                .param("idade", "30"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2))) // Verifica se o retorno tem 2 itens
                .andExpect(jsonPath("$[0].calendarioId")
                        .value(1))
                        .andExpect(jsonPath("$[0].categoria")
                                .value("Categoria 1"))
                                .andExpect(jsonPath("$[0].doses")
                                        .value("2 doses"))
                                        .andExpect(jsonPath("$[0].vacinas")
                                                .value("Vacina A"))
                                                .andExpect(jsonPath("$[1].calendarioId")
                                                        .value(2))
                                                        .andExpect(jsonPath("$[1].categoria").value("Categoria 2"))
                                                        .andExpect(jsonPath("$[1].doses")
                                                                .value("1 dose"))
                                                                .andExpect(jsonPath("$[1].vacinas")
                                                                        .value("Vacina B"));

        // Verify the service method was called
        verify(calendarioService, times(1)).buscarCalendario(30);
    }

    @Test
    void consultaCalendario_NaoEncontrarCalendarios_RetornarListaVazia() throws Exception {
        // Mock the behavior of the CalendarioService to return an empty list
        when(calendarioService.buscarCalendario(10))
                .thenReturn(new ArrayList<>());

        // Perform the GET request
        mockMvc.perform(get("/api/calendario/vacinacao")
                .param("idade", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0))); // Espera uma lista vazia

        // Verify the service method was called
        verify(calendarioService, times(1)).buscarCalendario(10);
    }

    @Test
    void consultaCalendario_IdadeNaoInformadad_RetornarErro() throws Exception {
        // Perform the GET request without age parameter
        mockMvc.perform(get("/api/calendario/vacinacao"))
                .andExpect(status().isBadRequest()); // Espera um erro de bad request

        // Verify that the service method was not called
        verify(calendarioService, never()).buscarCalendario(anyInt());
    }
}
