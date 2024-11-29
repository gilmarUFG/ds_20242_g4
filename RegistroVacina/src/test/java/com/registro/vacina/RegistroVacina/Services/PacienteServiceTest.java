package com.registro.vacina.RegistroVacina.Services;

import com.registro.vacina.RegistroVacina.entities.Paciente;
import com.registro.vacina.RegistroVacina.enuns.TipoComunicacaoEnum;
import com.registro.vacina.RegistroVacina.repositories.PacienteRepository;
import com.registro.vacina.RegistroVacina.services.PacienteService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @MockBean
    private PacienteRepository pacienteRepository;

    @Test
    public void buscarPaciente_PacienteExistente_RetornaPaciente() {
        // Arrange
        int pacienteId = 1;
        Paciente pacienteMock = new Paciente();
        pacienteMock.setId(pacienteId);
        pacienteMock.setNome("João Silva");
        Mockito.when(pacienteRepository.findById(pacienteId)).thenReturn(Optional.of(pacienteMock));

        // Act
        Paciente resultado = pacienteService.buscarPaciente(pacienteId);

        // Assert
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals("João Silva", resultado.getNome());
        Mockito.verify(pacienteRepository, Mockito.times(1)).findById(pacienteId);
    }

    @Test
    public void buscarPaciente_PacienteNaoExistente_RetornaExcecao() {
        // Arrange
        int pacienteId = 1;
        Mockito.when(pacienteRepository.findById(pacienteId)).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            pacienteService.buscarPaciente(pacienteId);
        });
        Mockito.verify(pacienteRepository, Mockito.times(1)).findById(pacienteId);
    }

    @Test
    public void setPreferenciaComunicacao_ComPacienteEComunicacaoExistentes() {
        // Arrange
        int pacienteId = 1;
        Paciente pacienteMock = new Paciente();
        pacienteMock.setId(pacienteId);
        pacienteMock.setNome("João Silva");
        Mockito.when(pacienteRepository.findById(pacienteId)).thenReturn(Optional.of(pacienteMock));

        TipoComunicacaoEnum tipoComunicacao = TipoComunicacaoEnum.EMAIL;

        // Act
        pacienteService.setPreferenciaComunicacao(pacienteId, tipoComunicacao);

        // Assert
        Assertions.assertEquals(tipoComunicacao.name(), pacienteMock.getTipoComunicacao());
        Mockito.verify(pacienteRepository, Mockito.times(1)).findById(pacienteId);
        Mockito.verify(pacienteRepository, Mockito.times(1)).save(pacienteMock);
    }

    @Test
    public void setPreferenciaComunicacao_ComPacienteOuComunicacaoNaoExistentes() {
        // Arrange
        int pacienteId = 1;
        TipoComunicacaoEnum tipoComunicacao = TipoComunicacaoEnum.SMS;
        Mockito.when(pacienteRepository.findById(pacienteId)).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            pacienteService.setPreferenciaComunicacao(pacienteId, tipoComunicacao);
        });
        Mockito.verify(pacienteRepository, Mockito.times(1)).findById(pacienteId);
        Mockito.verify(pacienteRepository, Mockito.never()).save(Mockito.any(Paciente.class));
    }
}
