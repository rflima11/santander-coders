package tech.ada.rflima.santander_coders.dto.mapper;

import tech.ada.rflima.santander_coders.dto.request.CriarUsuarioDTO;
import tech.ada.rflima.santander_coders.dto.response.EnderecoDTO;
import tech.ada.rflima.santander_coders.dto.response.UsuarioResponseDTO;
import tech.ada.rflima.santander_coders.model.Usuario;

public final class UsuarioDTOMapper {

    public static Usuario toEntity(CriarUsuarioDTO criarUsuarioDTO, EnderecoDTO enderecoDTO) {
        Usuario entity = new Usuario();
        entity.setCpf(criarUsuarioDTO.cpf());
        entity.setNome(criarUsuarioDTO.nome());
        entity.setEmail(criarUsuarioDTO.email());
        entity.setIdade(criarUsuarioDTO.idade());
        entity.setEndereco(EnderecoDTOMapper.toEntity(enderecoDTO));
        return entity;
    }

    public static UsuarioResponseDTO toResponse(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setCpf(usuario.getCpf());
        dto.setNome(usuario.getNome());
        dto.setIdade(usuario.getIdade());
        dto.setEndereco(EnderecoDTOMapper.toDTO(usuario.getEndereco()));
        return dto;
    }
}
