package tech.ada.rflima.santander_coders.service;

import org.springframework.stereotype.Service;
import tech.ada.rflima.santander_coders.dto.mapper.UsuarioDTOMapper;
import tech.ada.rflima.santander_coders.dto.request.CriarUsuarioDTO;
import tech.ada.rflima.santander_coders.dto.response.EnderecoDTO;
import tech.ada.rflima.santander_coders.dto.response.UsuarioResponseDTO;
import tech.ada.rflima.santander_coders.model.Usuario;
import tech.ada.rflima.santander_coders.repository.UsuarioRepository;

@Service
public class CriarUsuarioService {

    private final UsuarioRepository repository;
    private final BuscarEnderecoCEPService buscarEnderecoCEPService;

    public CriarUsuarioService(UsuarioRepository repository, BuscarEnderecoCEPService buscarEnderecoCEPService) {
        this.repository = repository;
        this.buscarEnderecoCEPService = buscarEnderecoCEPService;
    }

    public UsuarioResponseDTO executar(CriarUsuarioDTO usuarioQueSeraSalvo) {
        EnderecoDTO enderecoDTO = buscarEnderecoCEPService.execute(usuarioQueSeraSalvo.cep());

        Usuario entity = UsuarioDTOMapper.toEntity(usuarioQueSeraSalvo, enderecoDTO);
        Usuario usuarioSalvo = repository.save(entity);
        return UsuarioDTOMapper.toResponse(usuarioSalvo);
    }

}
