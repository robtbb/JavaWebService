package br.edu.ifsc.fln.Repository;

import br.edu.ifsc.fln.domain.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

	
}
