package com.registro.vacina.RegistroVacina.services;

import com.registro.vacina.RegistroVacina.dto.CalendarioDto;
import com.registro.vacina.RegistroVacina.entities.*;
import com.registro.vacina.RegistroVacina.repositories.CalendarioRepository;;
import com.registro.vacina.RegistroVacina.repositories.DoseRepository;
import com.registro.vacina.RegistroVacina.repositories.VacinaRepository;
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

//    @Autowired
//    private DoseService doseService;
//
//    @Autowired
//    private FaixaEtariaService faixaEtariaService;
//
  @Autowired
   private VacinaService vacinaService;






//Service e Repositiory para todos


    public List<CalendarioDto> buscarCalendario()
    {

        List<CalendarioDto> calendarioCompleto = new ArrayList<>();
        List<Calendario> retornoCalendario=calendarioRepository.findAll();


        for(Calendario c: retornoCalendario)
        {
            CalendarioDto calendarioDto = new CalendarioDto();
            calendarioDto.setCalendarioId(c.getId());
            Categoria categoria = new Categoria();
            Doses dose =  new Doses();
            FaixaEtaria faixaEtaria = new FaixaEtaria();
            Vacina vacina = new Vacina();

            /**Dose dose = new Dose();
             *  ---- fazer para todos
             **/

            categoria = categoriaService.buscarCategoriaId(c.getCategoriId());
//        dose = doseService.buscarDosesId(c.getDoseId());
//            faixaEtaria = faixaEtariaService.buscarFaixaEtariaId(c.getFaixaEtariaId());
            vacina = vacinaService.buscarVacina(c.getVacinaId());

            /** dose = doseService.buscarDoseId(c.getDosesId()
             * etc ---------------------- para todos  **/

            calendarioDto.setCategoria(categoria.getNome());
//            calendarioDto.setDoses(dose.getQuatidadeDose());
            calendarioDto.setVacinas(vacina.getNomeVacina());
//            calendarioDto.setFaixa_etaria(faixaEtaria);


            /** calendarioDto.setDoses(dose.getquatidadeDoses());
             * etc ---------------------- para todos  **/

            calendarioCompleto.add(calendarioDto);




        }

        return calendarioCompleto;


    }
}
