package tech.ada.rflima.santander_coders.service;

import org.springframework.stereotype.Service;
import tech.ada.rflima.santander_coders.dto.mapper.UsuarioDTOMapper;
import tech.ada.rflima.santander_coders.dto.request.CriarUsuarioDTO;
import tech.ada.rflima.santander_coders.dto.response.UsuarioResponseDTO;
import tech.ada.rflima.santander_coders.model.Usuario;
import tech.ada.rflima.santander_coders.repository.UsuarioRepository;

@Service
public class CriarUsuarioService {

    private final UsuarioRepository repository;

    public CriarUsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioResponseDTO executar(CriarUsuarioDTO usuarioQueSeraSalvo) {
        Usuario usuarioSalvo = repository.save(UsuarioDTOMapper.toEntity(usuarioQueSeraSalvo));
        return UsuarioDTOMapper.toResponse(usuarioSalvo);
    }

}
