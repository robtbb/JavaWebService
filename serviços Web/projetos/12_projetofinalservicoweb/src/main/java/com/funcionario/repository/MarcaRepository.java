package com.funcionario.repository;

import com.funcionario.domain.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Ajuste o tipo de ID para Long
@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    // JpaRepository já fornece métodos como findById, save, deleteById, etc.
}
