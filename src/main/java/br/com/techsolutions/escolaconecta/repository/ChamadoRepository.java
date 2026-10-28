package br.com.techsolutions.escolaconecta.repository;

import br.com.techsolutions.escolaconecta.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
}
