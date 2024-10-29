package tech.ada.rflima.santander_coders.service;

import org.springframework.stereotype.Service;
import tech.ada.rflima.santander_coders.model.Usuario;
import tech.ada.rflima.santander_coders.repository.UsuarioRepository;

@Service
public class ObterUsuarioEmailService {

    private final UsuarioRepository repository;

    public ObterUsuarioEmailService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario execute(String email) {
        return repository.encontrarPorEmailNative(email)
                .orElseThrow(() -> new RuntimeException(String.format("Não foi possível encontrar usuário com email %s", email)));
    }
}
