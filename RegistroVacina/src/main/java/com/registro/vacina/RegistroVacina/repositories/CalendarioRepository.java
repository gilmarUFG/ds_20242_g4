package com.registro.vacina.RegistroVacina.repositories;


import com.registro.vacina.RegistroVacina.entities.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, String> {
}
