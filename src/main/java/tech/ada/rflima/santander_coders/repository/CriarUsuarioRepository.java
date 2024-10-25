package tech.ada.rflima.santander_coders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.rflima.santander_coders.model.Usuario;

public interface CriarUsuarioRepository extends JpaRepository<Usuario, Long> {
}
