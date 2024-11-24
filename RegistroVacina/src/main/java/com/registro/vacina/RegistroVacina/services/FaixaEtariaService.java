package com.registro.vacina.RegistroVacina.services;


import com.registro.vacina.RegistroVacina.entities.FaixaEtaria;
import com.registro.vacina.RegistroVacina.repositories.FaixaEtariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FaixaEtariaService {

    @Autowired
    private FaixaEtariaRepository faixaEtariaRepository;

    public FaixaEtaria buscarFaixaEtariaId(int id)
    {
        Optional<FaixaEtaria> retorno = faixaEtariaRepository.findById(id);;
        return retorno.get();
    }

}
