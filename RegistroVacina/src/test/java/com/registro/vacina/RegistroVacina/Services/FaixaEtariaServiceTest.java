package com.registro.vacina.RegistroVacina.Services;

import com.registro.vacina.RegistroVacina.entities.FaixaEtaria;
import com.registro.vacina.RegistroVacina.repositories.FaixaEtariaRepository;
import com.registro.vacina.RegistroVacina.services.FaixaEtariaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class FaixaEtariaServiceTest {

    @Autowired
    private FaixaEtariaService faixaEtariaService;

    @MockBean
    private FaixaEtariaRepository faixaEtariaRepository;

    @Test
    public void buscarFaixaEtariaId_IdEncontrado_Sucesso() {
        // Arrange
        int id = 1;
        FaixaEtaria faixaEtaria = new FaixaEtaria();
        faixaEtaria.setId(id);
        faixaEtaria.setMesesInicial(0);
        faixaEtaria.setMesesFinal(12);

        when(faixaEtariaRepository.findById(id)).thenReturn(Optional.of(faixaEtaria));

        // Act
        FaixaEtaria result = faixaEtariaService.buscarFaixaEtariaId(id);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.getId());
        Assertions.assertEquals(0, result.getMesesInicial());
        Assertions.assertEquals(12, result.getMesesFinal());
        verify(faixaEtariaRepository, times(1)).findById(id);
    }

    @Test
    public void buscarFaixaEtariaId_IdNaoEncontrado_LancarExecao() {
        // Arrange
        int id = 1;

        when(faixaEtariaRepository.findById(id)).thenReturn(Optional.empty());

        // Act e Assert
        Assertions.assertThrows(
                java.util.NoSuchElementException.class,
                () -> faixaEtariaService.buscarFaixaEtariaId(id));
        verify(faixaEtariaRepository, times(1)).findById(id);
    }
}