package com.registro.vacina.RegistroVacina.services;



import com.registro.vacina.RegistroVacina.entities.Vacina;
import com.registro.vacina.RegistroVacina.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;

    public Vacina buscarVacina(int id)
    {
        Optional<Vacina> retorno = vacinaRepository.findById(id);
        return retorno.get();

    }

}
