package tech.ada.rflima.santander_coders.dto.mapper;

import tech.ada.rflima.santander_coders.dto.response.EnderecoDTO;
import tech.ada.rflima.santander_coders.model.Endereco;

public final class EnderecoDTOMapper {

    public static Endereco toEntity(EnderecoDTO dto) {
        Endereco endereco = new Endereco();
        endereco.setBairro(dto.getBairro());
        endereco.setCep(dto.getCep());
        endereco.setComplemento(dto.getComplemento());
        endereco.setEstado(dto.getEstado());
        endereco.setRegiao(dto.getRegiao());
        endereco.setLogradouro(dto.getLogradouro());
        return endereco;
    }

    public static EnderecoDTO toDTO(Endereco entity) {
        EnderecoDTO dto = new EnderecoDTO();
        dto.setBairro(entity.getBairro());
        dto.setCep(entity.getCep());
        dto.setComplemento(entity.getComplemento());
        dto.setEstado(entity.getEstado());
        dto.setRegiao(entity.getRegiao());
        dto.setLogradouro(entity.getLogradouro());
        return dto;
    }
}
