package br.com.techsolutions.escolaconecta.repository;
import br.com.techsolutions.escolaconecta.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
