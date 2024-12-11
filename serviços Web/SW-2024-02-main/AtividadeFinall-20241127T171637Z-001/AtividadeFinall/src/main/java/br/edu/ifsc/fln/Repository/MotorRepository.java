package br.edu.ifsc.fln.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifsc.fln.domain.Motor;

@Repository
public interface MotorRepository extends JpaRepository<Motor, Long> {
}
