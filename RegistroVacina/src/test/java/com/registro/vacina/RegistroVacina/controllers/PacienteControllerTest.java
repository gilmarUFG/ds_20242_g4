package com.registro.vacina.RegistroVacina.controllers;

import com.registro.vacina.RegistroVacina.enuns.TipoComunicacaoEnum;
import com.registro.vacina.RegistroVacina.services.PacienteService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PacienteService pacienteService;

    @Test
    public void atualizarPreferenciaComunicacao_TipoValido_DeveRetornarOk() throws Exception {
        int pacienteId = 1;
        String tipoComunicacao = "EMAIL";

        doNothing().when(pacienteService).setPreferenciaComunicacao(eq(pacienteId), eq(TipoComunicacaoEnum.EMAIL));

        mockMvc.perform(put("/api/paciente/{id}/comunicacao", pacienteId)
                        .param("tipoComunicacao", tipoComunicacao))
                .andExpect(status().isOk())
                .andExpect(content().string("Preferência de comunicação atualizada com sucesso."));
    }

    @Test
    public void atualizarPreferenciaComunicacao_TipoInvalido_DeveRetornarBadRequest() throws Exception {
        int pacienteId = 1;
        String tipoComunicacao = "INVALIDO";

        mockMvc.perform(put("/api/paciente/{id}/comunicacao", pacienteId)
                        .param("tipoComunicacao", tipoComunicacao))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Opção inválida. Valores permitidos: EMAIL, SMS, TELEFONE."));
    }

    @Test
    public void atualizarPreferenciaComunicacao_PacienteNaoEncontrado_DeveRetornarNotFound() throws Exception {
        int pacienteId = 99;
        String tipoComunicacao = "EMAIL";

        doThrow(new EntityNotFoundException("Paciente com ID " + pacienteId + " não encontrado."))
                .when(pacienteService).setPreferenciaComunicacao(eq(pacienteId), eq(TipoComunicacaoEnum.EMAIL));

        mockMvc.perform(put("/api/paciente/{id}/comunicacao", pacienteId)
                        .param("tipoComunicacao", tipoComunicacao))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Paciente com ID " + pacienteId + " não encontrado."));
    }

    @Test
    public void atualizarPreferenciaComunicacao_ErroInterno_DeveRetornarInternalServerError() throws Exception {
        int pacienteId = 1;
        String tipoComunicacao = "EMAIL";

        doThrow(new RuntimeException("Erro genérico."))
                .when(pacienteService).setPreferenciaComunicacao(eq(pacienteId), eq(TipoComunicacaoEnum.EMAIL));

        mockMvc.perform(put("/api/paciente/{id}/comunicacao", pacienteId)
                        .param("tipoComunicacao", tipoComunicacao))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Erro ao atualizar preferência de comunicação."));
    }
}
