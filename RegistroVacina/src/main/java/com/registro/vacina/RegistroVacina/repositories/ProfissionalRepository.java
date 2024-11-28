package com.registro.vacina.RegistroVacina.repositories;

import com.registro.vacina.RegistroVacina.entities.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {
    Optional<Profissional> findByCpf(String cpf);
}