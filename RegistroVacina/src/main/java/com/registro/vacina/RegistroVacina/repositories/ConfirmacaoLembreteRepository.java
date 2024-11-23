package com.registro.vacina.RegistroVacina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.vacina.RegistroVacina.entities.ConfirmacaoLembrete;

@Repository
public interface ConfirmacaoLembreteRepository extends JpaRepository<ConfirmacaoLembrete, Integer> {
}
