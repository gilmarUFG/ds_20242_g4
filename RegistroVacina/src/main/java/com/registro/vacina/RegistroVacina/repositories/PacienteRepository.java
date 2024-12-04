package com.registro.vacina.RegistroVacina.repositories;

import com.registro.vacina.RegistroVacina.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
    Optional<Paciente> findByCpf(String cpf);
}
