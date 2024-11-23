package com.registro.vacina.RegistroVacina.services;

import com.registro.vacina.RegistroVacina.entities.Categoria;
import com.registro.vacina.RegistroVacina.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarCategoriaId(int id)
    {
        Optional<Categoria>retorno = categoriaRepository.findById(id);
        return retorno.get();
    }
}
