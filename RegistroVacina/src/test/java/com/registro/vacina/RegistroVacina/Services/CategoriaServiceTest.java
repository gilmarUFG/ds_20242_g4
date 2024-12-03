package com.registro.vacina.RegistroVacina.Services;


import com.registro.vacina.RegistroVacina.entities.Categoria;
import com.registro.vacina.RegistroVacina.repositories.CategoriaRepository;
import com.registro.vacina.RegistroVacina.services.CategoriaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootTest
public class CategoriaServiceTest {

    @Autowired
    private CategoriaService categoriaService;

    @MockBean
    private CategoriaRepository categoriaRepository;

    @Test
    public void buscarCategoriaId_Encontrado_RetornaObjetoValido() {
        // Arrange
        int id = 1;
        Categoria categoriaMock = new Categoria();
        categoriaMock.setId(id);
        categoriaMock.setNome("Categoria Teste");

        Mockito.when(categoriaRepository.findById(id)).thenReturn(Optional.of(categoriaMock));

        // Act
        Categoria resultado = categoriaService.buscarCategoriaId(id);

        // Assert
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(id, resultado.getId());
        Assertions.assertEquals("Categoria Teste", resultado.getNome());
    }

    @Test
    public void BuscarCategoriaId_NaoEncontrado_RetornaOptionalEmpty() {
        // Arrange
        int id = 2;

        Mockito.when(categoriaRepository.findById(id)).thenReturn(Optional.empty());

        // Act e Assert
        Assertions.assertThrows(NoSuchElementException.class, () -> categoriaService.buscarCategoriaId(id));
    }
}
