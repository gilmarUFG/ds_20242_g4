package com.registro.vacina.RegistroVacina.repositories;

import com.registro.vacina.RegistroVacina.entities.Calendario;
import com.registro.vacina.RegistroVacina.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{
}
