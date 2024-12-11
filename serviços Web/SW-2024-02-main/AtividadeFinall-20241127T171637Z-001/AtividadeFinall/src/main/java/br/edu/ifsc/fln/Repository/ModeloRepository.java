package br.edu.ifsc.fln.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifsc.fln.domain.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
