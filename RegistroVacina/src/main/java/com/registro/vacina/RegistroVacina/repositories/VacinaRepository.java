package com.registro.vacina.RegistroVacina.repositories;
import com.registro.vacina.RegistroVacina.entities.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinaRepository extends JpaRepository <Vacina, Integer> {
}
