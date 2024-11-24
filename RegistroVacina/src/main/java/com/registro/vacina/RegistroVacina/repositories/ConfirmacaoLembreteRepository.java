package com.registro.vacina.RegistroVacina.repositories;

import com.registro.vacina.RegistroVacina.entities.ConfirmacaoLembrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmacaoLembreteRepository extends JpaRepository<ConfirmacaoLembrete, Integer> {
    // Repositório padrão para operações de CRUD com a entidade ConfirmacaoLembrete
}
