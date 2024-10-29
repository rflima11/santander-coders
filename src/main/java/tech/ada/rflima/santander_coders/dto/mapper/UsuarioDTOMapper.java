package tech.ada.rflima.santander_coders.dto.mapper;

import tech.ada.rflima.santander_coders.dto.request.CriarUsuarioDTO;
import tech.ada.rflima.santander_coders.dto.response.UsuarioResponseDTO;
import tech.ada.rflima.santander_coders.model.Usuario;

public class UsuarioDTOMapper {

    public static Usuario toEntity(CriarUsuarioDTO criarUsuarioDTO) {
        Usuario entity = new Usuario();
        entity.setCpf(criarUsuarioDTO.cpf());
        entity.setNome(criarUsuarioDTO.nome());
        entity.setEmail(criarUsuarioDTO.email());
        entity.setIdade(criarUsuarioDTO.idade());
        return entity;
    }

    public static UsuarioResponseDTO toResponse(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setCpf(usuario.getCpf());
        dto.setNome(usuario.getNome());
        dto.setIdade(usuario.getIdade());
        return dto;
    }
}
