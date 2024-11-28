package com.registro.vacina.RegistroVacina.Services;

import com.registro.vacina.RegistroVacina.dto.CalendarioDto;
import com.registro.vacina.RegistroVacina.entities.*;
import com.registro.vacina.RegistroVacina.repositories.CalendarioRepository;
import com.registro.vacina.RegistroVacina.services.CalendarioService;
import com.registro.vacina.RegistroVacina.services.CategoriaService;
import com.registro.vacina.RegistroVacina.services.DoseService;
import com.registro.vacina.RegistroVacina.services.FaixaEtariaService;
import com.registro.vacina.RegistroVacina.services.VacinaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
class CalendarioServiceTest {

    @Autowired
    private CalendarioService calendarioService;

    @MockBean
    private CalendarioRepository calendarioRepository;

    @MockBean
    private CategoriaService categoriaService;

    @MockBean
    private DoseService doseService;

    @MockBean
    private FaixaEtariaService faixaEtariaService;

    @MockBean
    private VacinaService vacinaService;

    // ---------- buscarCalendario ---------- //

    @Test
    void buscarCalendario_IdadeCorreta_RetornaCalendarioFiltrado() {
        // Arrange
        int idade = 5;

        Calendario calendario = criarCalendarioMock();
        Categoria categoria = criarCategoriaMock("Infantil");
        Doses dose = criarDoseMock("2");
        FaixaEtaria faixaEtaria = criarFaixaEtariaMock(36, 72);
        Vacina vacina = criarVacinaMock("Vacina A");

        Mockito.when(calendarioRepository.findAll()).thenReturn(List.of(calendario));
        Mockito.when(categoriaService.buscarCategoriaId(10)).thenReturn(categoria);
        Mockito.when(doseService.buscarDosesId(20)).thenReturn(dose);
        Mockito.when(faixaEtariaService.buscarFaixaEtariaId(30)).thenReturn(faixaEtaria);
        Mockito.when(vacinaService.buscarVacina(40)).thenReturn(vacina);

        // Act
        List<CalendarioDto> resultado = calendarioService.buscarCalendario(idade);

        // Assert
        Assertions.assertEquals(1, ((List<?>) resultado).size());
        CalendarioDto dto = resultado.get(0);
        Assertions.assertEquals("Infantil", dto.getCategoria());
        Assertions.assertEquals("2", dto.getDoses());
        Assertions.assertEquals("Vacina A", dto.getVacinas());
        Assertions.assertEquals("3 Anos ", dto.getFaixaEtariaObjeto().getMesesinicial());
        Assertions.assertEquals("6 Anos", dto.getFaixaEtariaObjeto().getMesesfinal());
    }

    @Test
    void buscarCalendario_IdadeForaDaFaixa_RetornaListaVazia() {
        // Arrange
        int idade = 10;

        Calendario calendario = new Calendario();
        calendario.setId(1);
        calendario.setCategoriId(1);
        calendario.setDoseId(1);
        calendario.setFaixaEtariaId(30);
        calendario.setVacinaId(1);

        FaixaEtaria faixaEtaria = new FaixaEtaria();
        faixaEtaria.setMesesInicial(36);
        faixaEtaria.setMesesFinal(72);

        Categoria categoria = new Categoria();
        categoria.setNome("Categoria Teste");

        Doses dose = new Doses();
        dose.setQuatidadeDose("2 doses");

        Vacina vacina = new Vacina();
        vacina.setNomeVacina("Vacina Teste");

        Mockito.when(calendarioRepository.findAll()).thenReturn(List.of(calendario));
        Mockito.when(faixaEtariaService.buscarFaixaEtariaId(30)).thenReturn(faixaEtaria);
        Mockito.when(categoriaService.buscarCategoriaId(1)).thenReturn(categoria);
        Mockito.when(doseService.buscarDosesId(1)).thenReturn(dose);
        Mockito.when(vacinaService.buscarVacina(1)).thenReturn(vacina);

        // Act
        List<CalendarioDto> resultado = calendarioService.buscarCalendario(idade);

        // Assert
        Assertions.assertTrue(resultado.isEmpty(), "A lista de calendários deve estar vazia para uma idade fora da faixa etária.");
    }

    @Test
    void buscarCalendario_RepositorioVazio_RetornaListaVazia() {
        // Arrange
        Mockito.when(calendarioRepository.findAll()).thenReturn(List.of());

        // Act
        List<CalendarioDto> resultado = calendarioService.buscarCalendario(5);

        // Assert
        Assertions.assertTrue(resultado.isEmpty());
    }

    @Test
    void buscarCalendario_ServicoFalha_LancaExcecao() {
        // Arrange
        int idade = 5;
        Calendario calendario = criarCalendarioMock();

        Mockito.when(calendarioRepository.findAll()).thenReturn(List.of(calendario));
        Mockito.when(categoriaService.buscarCategoriaId(10)).thenThrow(new RuntimeException("Erro no serviço de categoria"));

        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> calendarioService.buscarCalendario(idade));
    }

    // ---------- converterMesesParaAnos ---------- //

    @Test
    void converterMesesParaAnos_ZeroMeses_RetornaZero() {
        // Act
        int resultado = calendarioService.converterMesesParaAnos(0);

        // Assert
        Assertions.assertEquals(0, resultado);
    }

    @Test
    void converterMesesParaAnos_MenosDeUmAno_RetornaZero() {
        // Act
        int resultado = calendarioService.converterMesesParaAnos(11);

        // Assert
        Assertions.assertEquals(0, resultado);
    }

    @Test
    void converterMesesParaAnos_VariosMeses_RetornaMaisDeUmAno() {
        // Act
        int resultado = calendarioService.converterMesesParaAnos(36);

        // Assert
        Assertions.assertEquals(3, resultado);
    }

    // ---------- validarFaixaEtaria ---------- //

    @Test
    void validarFaixaEtaria_IdadeDentroDoIntervalo_RetornaTrue() {
        // Act
        boolean resultado = calendarioService.validarFaixaEtaria(5, 3, 6);

        // Assert
        Assertions.assertTrue(resultado);
    }

    @Test
    void validarFaixaEtaria_IdadeAbaixoDoIntervalo_RetornaFalse() {
        // Act
        boolean resultado = calendarioService.validarFaixaEtaria(2, 3, 6);

        // Assert
        Assertions.assertFalse(resultado);
    }

    @Test
    void validarFaixaEtaria_IdadeAcimaDoIntervalo_RetornarFalse() {
        // Act
        boolean resultado = calendarioService.validarFaixaEtaria(7, 3, 6);

        // Assert
        Assertions.assertFalse(resultado);
    }

    // ---------- metodos para auxiliar os testes ---------- //

    private Calendario criarCalendarioMock() {
        Calendario calendario = new Calendario();
        calendario.setId(1);
        calendario.setCategoriId(10);
        calendario.setDoseId(20);
        calendario.setFaixaEtariaId(30);
        calendario.setVacinaId(40);
        return calendario;
    }

    private Categoria criarCategoriaMock(String nome) {
        Categoria categoria = new Categoria();
        categoria.setNome(nome);
        return categoria;
    }

    private Doses criarDoseMock(String quantidade) {
        Doses dose = new Doses();
        dose.setQuatidadeDose(quantidade);
        return dose;
    }

    private FaixaEtaria criarFaixaEtariaMock(int mesesInicial, int mesesFinal) {
        FaixaEtaria faixaEtaria = new FaixaEtaria();
        faixaEtaria.setMesesInicial(mesesInicial);
        faixaEtaria.setMesesFinal(mesesFinal);
        return faixaEtaria;
    }

    private Vacina criarVacinaMock(String nomeVacina) {
        Vacina vacina = new Vacina();
        vacina.setNomeVacina(nomeVacina);
        return vacina;
    }
}
