package com.registro.vacina.RegistroVacina.Services;

import com.registro.vacina.RegistroVacina.entities.Vacina;
import com.registro.vacina.RegistroVacina.repositories.VacinaRepository;
import com.registro.vacina.RegistroVacina.services.VacinaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class VacinaServiceTest {

    @Autowired
    private VacinaService vacinaService;

    @MockBean
    private VacinaRepository vacinaRepository;

    @Test
    public void buscarVacina_IdExiste_RetornaVacina() {
        // Arrange
        Vacina vacina = new Vacina();
        vacina.setId(1);
        vacina.setNomeVacina("Vacina Teste");

        Mockito.when(vacinaRepository.findById(1)).thenReturn(Optional.of(vacina));

        // Act
        Vacina resultado = vacinaService.buscarVacina(1);

        // Assert
        Assertions.assertEquals(1, resultado.getId());
        Assertions.assertEquals("Vacina Teste", resultado.getNomeVacina());
    }

    @Test
    public void buscarVacina_IdNaoExiste_LancarExcecao() {
        // Arrange
        Mockito.when(vacinaRepository.findById(2)).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(
                java.util.NoSuchElementException.class,
                () -> vacinaService.buscarVacina(2),
                "NoSuchElementException"
        );
    }
}
