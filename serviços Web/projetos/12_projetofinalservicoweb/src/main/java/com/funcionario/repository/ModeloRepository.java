package com.funcionario.repository;

import com.funcionario.domain.ECategoria;
import com.funcionario.domain.Modelo;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}

