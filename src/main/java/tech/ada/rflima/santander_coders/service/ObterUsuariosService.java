package tech.ada.rflima.santander_coders.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.ada.rflima.santander_coders.model.Usuario;
import tech.ada.rflima.santander_coders.repository.UsuarioRepository;

@Service
public class ObterUsuariosService {

    private final UsuarioRepository usuarioRepository;

    public ObterUsuariosService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Page<Usuario> execute(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }
}
