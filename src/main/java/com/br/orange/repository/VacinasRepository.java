package com.br.orange.repository;

import com.br.orange.model.Vacinas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinasRepository extends JpaRepository<Vacinas, Long> {
}
