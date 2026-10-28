package br.com.techsolutions.escolaconecta.repository;

import br.com.techsolutions.escolaconecta.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
