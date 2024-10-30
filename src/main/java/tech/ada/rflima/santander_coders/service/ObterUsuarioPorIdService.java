package tech.ada.rflima.santander_coders.service;

import org.springframework.stereotype.Service;
import tech.ada.rflima.santander_coders.exceptions.UsuarioNaoEncontradoException;
import tech.ada.rflima.santander_coders.model.Usuario;
import tech.ada.rflima.santander_coders.repository.UsuarioRepository;

@Service
public class ObterUsuarioPorIdService {

    private final UsuarioRepository repository;

    public ObterUsuarioPorIdService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario execute(Long id) {
        return repository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException(String.format("Não foi possível encontrar usuário com id %s", id)));
    }

}
