package com.registro.vacina.RegistroVacina.repositories;


import com.registro.vacina.RegistroVacina.entities.HistoricoVacinacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoVacinacaoRepository extends JpaRepository<HistoricoVacinacao, Integer>{


    List<HistoricoVacinacao> findByPacienteId(@Param("pacienteId") int pacienteId);

}

