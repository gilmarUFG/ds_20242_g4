package com.registro.vacina.RegistroVacina.services;

import com.registro.vacina.RegistroVacina.dto.HistoricoVacinacaoDTO;
import com.registro.vacina.RegistroVacina.entities.Doses;
import com.registro.vacina.RegistroVacina.entities.HistoricoVacinacao;
import com.registro.vacina.RegistroVacina.entities.Vacina;
import com.registro.vacina.RegistroVacina.repositories.HistoricoVacinacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class HistoricoVacinacaoService {

    @Autowired
    private HistoricoVacinacaoRepository historicoVacinacaoRepository;

    @Autowired
    private DoseService doseService;

    @Autowired
    private VacinaService vacinaService;

    public List<HistoricoVacinacaoDTO> buscarHistoricoVacinacao(int pacienteId, String nomeVacina, String dataVacinacao) {

        List<HistoricoVacinacao> retorno = historicoVacinacaoRepository.findByPacienteId(pacienteId);
        List<HistoricoVacinacaoDTO> novoHistoricoVacinacao = new ArrayList<>(); // Criação de Lista


        // Filtro

        for(HistoricoVacinacao h : retorno) {

            Doses doses = doseService.buscarDosesId(h.getDose());
            Vacina vacina = vacinaService.buscarVacina(h.getVacina());

            if(nomeVacina != null) {
                if(!nomeVacina.equals(vacina.getNomeVacina())) {
                    continue;
                }
            }

            if(dataVacinacao != null) {
                if(!Objects.equals(converterDataUSA(dataVacinacao), formatarData(h.getDataVacinacao()))) {
                    continue;
                }
            }


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

    private Date converterDataUSA(String dataBR) {
        // Define os formatos
        SimpleDateFormat formatoBR = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoUSA = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Converte a string BR para um objeto Date
            Date data = formatoBR.parse(dataBR);

            // Converte o objeto Date para o formato USA
            String dataFormatada = formatoUSA.format(data);

            // Retorna a data convertida
            return formatoUSA.parse(dataFormatada);
        } catch(ParseException e) {
            e.printStackTrace();
            return null; // ou lançar uma exceção
        }
    }

    private Date formatarData(Date data) {
        // Define o formato desejado (somente data)
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        // Formata a data para uma string
        String dataFormatada = formato.format(data);

        try {
            // Converte a string de volta para um objeto Date
            return formato.parse(dataFormatada);
        } catch(ParseException e) {
            e.printStackTrace();
            return null; // ou lançar uma exceção
        }
    }

}


