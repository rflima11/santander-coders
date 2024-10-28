package tech.ada.rflima.santander_coders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.rflima.santander_coders.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNomeContaining(String nome);

    Optional<Usuario> findByCpf(String cpf);
}
