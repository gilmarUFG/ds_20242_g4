package com.registro.vacina.RegistroVacina.repositories;

import com.registro.vacina.RegistroVacina.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository <Paciente, String> {

   Paciente findByCpf(String cpf);
}
