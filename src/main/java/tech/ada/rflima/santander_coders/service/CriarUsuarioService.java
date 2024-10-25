package tech.ada.rflima.santander_coders.service;

import org.springframework.stereotype.Service;
import tech.ada.rflima.santander_coders.model.Usuario;
import tech.ada.rflima.santander_coders.repository.CriarUsuarioRepository;

@Service
public class CriarUsuarioService {

    private final CriarUsuarioRepository repository;

    public CriarUsuarioService(CriarUsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario executar(Usuario usuarioQueSeraSalvo) {
        Usuario usuarioSalvo = repository.save(usuarioQueSeraSalvo);
        return  usuarioSalvo;
    }

}
