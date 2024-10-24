package tech.ada.rflima.santander_coders.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tech.ada.rflima.santander_coders.model.Usuario;

@Service
public class ObterUsuarioService {

    @Value("${abacate.name}")
    String nome;

    public Usuario execute(Long id) {
        return new Usuario(id, nome, 30);
    }
}
