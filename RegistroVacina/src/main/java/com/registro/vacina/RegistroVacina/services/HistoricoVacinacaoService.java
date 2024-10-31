package com.registro.vacina.RegistroVacina.services;

import com.registro.vacina.RegistroVacina.dto.HistoricoVacinacaoDTO;
import com.registro.vacina.RegistroVacina.entities.Doses;
import com.registro.vacina.RegistroVacina.entities.HistoricoVacinacao;
import com.registro.vacina.RegistroVacina.entities.Vacina;
import com.registro.vacina.RegistroVacina.repositories.HistoricoVacinacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HistoricoVacinacaoService {

    @Autowired
    private HistoricoVacinacaoRepository historicoVacinacaoRepository;

    @Autowired
    private DoseService doseService;

    @Autowired
    private VacinaService vacinaService;

    public List<HistoricoVacinacaoDTO> buscarHistoricoVacinacao(int pacienteId) {
        List<HistoricoVacinacao> retorno = historicoVacinacaoRepository.findByPacienteId(pacienteId);
        List<HistoricoVacinacaoDTO> novoHistoricoVacinacao = new ArrayList<>(); // Criação de Lista

        for (HistoricoVacinacao h : retorno) {

            Doses doses = doseService.buscarDosesId(h.getDose());
            Vacina vacina = vacinaService.buscarVacina(h.getVacina());

            HistoricoVacinacaoDTO historicoVacinacaoDTO = new HistoricoVacinacaoDTO();
            historicoVacinacaoDTO.setDataVacinacao(h.getDataVacinacao());
            historicoVacinacaoDTO.setAnoVencimneto(h.getAnoVencimento());
            historicoVacinacaoDTO.setQuantidadeDoses(doses.getQuatidadeDose());
            historicoVacinacaoDTO.setLoteVacinacao(h.getLoteVacinacao());
            historicoVacinacaoDTO.setNomeVacina(vacina.getNomeVacina());



            novoHistoricoVacinacao.add(historicoVacinacaoDTO);


        }

        return novoHistoricoVacinacao;
    }

}


