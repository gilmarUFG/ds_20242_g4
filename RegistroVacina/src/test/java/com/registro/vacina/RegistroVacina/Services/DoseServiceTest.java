package com.registro.vacina.RegistroVacina.Services;

import com.registro.vacina.RegistroVacina.entities.Doses;
import com.registro.vacina.RegistroVacina.repositories.DoseRepository;
import com.registro.vacina.RegistroVacina.services.DoseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootTest
public class DoseServiceTest {

    @Autowired
    private DoseService doseService;

    @MockBean
    private DoseRepository doseRepository;

    @Test
    public void buscarDosesId_IdExistente_RetornaSucesso() {
        // Arrange
        int id = 1;
        Doses mockDose = new Doses();
        mockDose.setId(id);
        mockDose.setQuatidadeDose("2 doses");

        Mockito.when(doseRepository.findById(id)).thenReturn(Optional.of(mockDose));

        // Act
        Doses resultado = doseService.buscarDosesId(id);

        // Assert
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(id, resultado.getId());
        Assertions.assertEquals("2 doses", resultado.getQuatidadeDose());
    }

    @Test
    public void buscarDosesId_IdNaoEncontrado_LancaExecao() {
        // Arrange
        int id = 999;
        Mockito.when(doseRepository.findById(id)).thenReturn(Optional.empty());

        // Act e Assert
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            doseService.buscarDosesId(id);
        });
    }
}
