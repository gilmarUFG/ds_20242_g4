package com.registro.vacina.RegistroVacina.services;

import com.registro.vacina.RegistroVacina.dto.CalendarioDto;
import com.registro.vacina.RegistroVacina.dto.FaixaEtariaDTO;
import com.registro.vacina.RegistroVacina.entities.*;
import com.registro.vacina.RegistroVacina.repositories.CalendarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarioService {

    @Autowired
    private CalendarioRepository calendarioRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private DoseService doseService;

    @Autowired
    private FaixaEtariaService faixaEtariaService;

    @Autowired
    private VacinaService vacinaService;

    public List<CalendarioDto> buscarCalendario(int idade) {
        List<CalendarioDto> calendarioCompleto = new ArrayList<>();
        List<Calendario> retornoCalendario = calendarioRepository.findAll();

        for(Calendario c : retornoCalendario) {
            CalendarioDto calendarioDto = new CalendarioDto();
            calendarioDto.setCalendarioId(c.getId());
            Categoria categoria = new Categoria();
            Doses dose = new Doses();
            FaixaEtaria faixaEtaria = new FaixaEtaria();
            // Entidade>> variavel>> Objeto
            Vacina vacina = new Vacina();

            /**Dose dose = new Dose();
             *  ---- fazer para todos
             **/

            categoria = categoriaService.buscarCategoriaId(c.getCategoriId());
            dose = doseService.buscarDosesId(c.getDoseId());
            faixaEtaria = faixaEtariaService.buscarFaixaEtariaId(c.getFaixaEtariaId());
            vacina = vacinaService.buscarVacina(c.getVacinaId());

            /** dose = doseService.buscarDoseId(c.getDosesId()
             * etc ---------------------- para todos  **/

            FaixaEtariaDTO faixaEtariaDTO = new FaixaEtariaDTO();
            faixaEtariaDTO.setMesesinicial(converterMesesParaAnos(faixaEtaria.getMesesInicial()) + " Anos "); // conersão de FaixaEtaria para FaixaEtariaDTO
            faixaEtariaDTO.setMesesfinal(converterMesesParaAnos(faixaEtaria.getMesesFinal()) + " Anos");

            calendarioDto.setCategoria(categoria.getNome());
            calendarioDto.setDoses(dose.getQuatidadeDose());
            calendarioDto.setVacinas(vacina.getNomeVacina());
            calendarioDto.setFaixaEtariaObjeto(faixaEtariaDTO);

            /** calendarioDto.setDoses(dose.getquatidadeDoses());
             * etc ---------------------- para todos  **/
            if(validarFaixaEtaria(idade, converterMesesParaAnos(faixaEtaria.getMesesInicial()), converterMesesParaAnos(faixaEtaria.getMesesFinal()))) {
                calendarioCompleto.add(calendarioDto);
            }
        }
        return calendarioCompleto;
    }

    // Regra de alteração de meses  para anos
    public int converterMesesParaAnos(int meses) {
        return meses / 12;
    }

    public boolean validarFaixaEtaria(int idade, int anoInicial, int anoFinal) {
        if(idade >= anoInicial && idade <= anoFinal) {
            return true;
        }
        return false;
    }

}
