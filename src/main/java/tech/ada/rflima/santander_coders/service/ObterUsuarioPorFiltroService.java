package tech.ada.rflima.santander_coders.service;

import org.springframework.stereotype.Service;
import tech.ada.rflima.santander_coders.model.Usuario;
import tech.ada.rflima.santander_coders.repository.UsuarioRepository;

import java.util.List;

@Service
public class ObterUsuarioPorFiltroService {

    public final UsuarioRepository repository;

    public ObterUsuarioPorFiltroService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario obterUsuarioPorCpf(String cpf) {
        return repository.findByCpf(cpf).orElseThrow(() -> new RuntimeException(String.format("Não foi possível encontrar usuário com cpf %s", cpf)));
    }

    public List<Usuario> obterUsuariosPorNomeContendo(String nome) {
       return repository.findByNomeContaining(nome);
    }
}
