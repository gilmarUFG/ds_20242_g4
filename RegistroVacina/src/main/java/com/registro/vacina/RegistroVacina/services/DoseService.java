package com.registro.vacina.RegistroVacina.services;


import com.registro.vacina.RegistroVacina.entities.Doses;
import com.registro.vacina.RegistroVacina.repositories.DoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoseService {

    @Autowired
    private DoseRepository doseRepository;

    public Doses buscarDosesId(int id){

        Optional<Doses>retorno = doseRepository.findById(id);
        return retorno.get();

    }

}
