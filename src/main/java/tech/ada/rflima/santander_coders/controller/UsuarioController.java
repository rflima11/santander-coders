package tech.ada.rflima.santander_coders.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.ada.rflima.santander_coders.dto.request.CriarUsuarioDTO;
import tech.ada.rflima.santander_coders.dto.response.UsuarioResponseDTO;
import tech.ada.rflima.santander_coders.model.Usuario;
import tech.ada.rflima.santander_coders.service.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final ObterUsuarioPorIdService obterUsuarioPorIdService;
    private final CriarUsuarioService criarUsuarioService;
    private final ObterUsuarioPorFiltroService obterUsuarioPorFiltroService;
    private final ObterUsuariosService obterUsuariosService;
    private final ObterUsuarioEmailService obterUsuarioPorEmailService;

    public UsuarioController(ObterUsuarioPorIdService obterUsuarioPorIdService,
                             CriarUsuarioService criarUsuarioService,
                             ObterUsuarioPorFiltroService obterUsuarioPorFiltroService,
                             ObterUsuariosService obterUsuariosService, ObterUsuarioEmailService obterUsuarioPorEmailService) {
        this.obterUsuarioPorIdService = obterUsuarioPorIdService;
        this.obterUsuariosService = obterUsuariosService;
        this.criarUsuarioService = criarUsuarioService;
        this.obterUsuarioPorFiltroService = obterUsuarioPorFiltroService;
        this.obterUsuarioPorEmailService = obterUsuarioPorEmailService;
    }

    @GetMapping("/{id}")
    public Usuario obterUsuarioPorId(@PathVariable Long id) {
        return obterUsuarioPorIdService.execute(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UsuarioResponseDTO criarUsuario(@Valid @RequestBody CriarUsuarioDTO usuario) {
        return criarUsuarioService.executar(usuario);
    }

    @GetMapping
    public Page<Usuario> obterUsuariosPaginados(Pageable pageable) {
        return obterUsuariosService.execute(pageable);
    }

    @GetMapping("/nome")
    public List<Usuario> obterUsuariosPorFiltro(@RequestParam String nome) {
        return obterUsuarioPorFiltroService.obterUsuariosPorNomeContendo(nome);
    }

    @GetMapping("/cpf")
    public Usuario obterUsuariosPorCpf(@RequestParam String cpf) {
        return obterUsuarioPorFiltroService.obterUsuarioPorCpf(cpf);
    }

    @GetMapping("/email")
    public Usuario obterUsuarioPorEmail(@RequestParam String email) {
        return obterUsuarioPorEmailService.execute(email);
    }
}



