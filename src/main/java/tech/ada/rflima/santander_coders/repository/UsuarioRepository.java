package tech.ada.rflima.santander_coders.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.ada.rflima.santander_coders.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //Query Methods
    List<Usuario> findByNomeContaining(String nome);
    Optional<Usuario> findByCpf(String cpf);

    //Page
    Page<Usuario> findAll(Pageable pageable);

    //JPQL = Java Persistence Query Languauge
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Optional<Usuario> encontrarPorEmail(@Param("email") String email);

    //NATIVE
    @Query(value = "SELECT u.* FROM USUARIO where email = :email", nativeQuery = true)
    Optional<Usuario> encontrarPorEmailNative(@Param("email") String email);

    Optional<Usuario> findByEmail(String username);
}
