package com.registro.vacina.RegistroVacina.repositories;

import com.registro.vacina.RegistroVacina.entities.Doses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository <Doses, Integer> {
}
