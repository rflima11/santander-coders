package tech.ada.rflima.santander_coders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.ada.rflima.santander_coders.model.Usuario;
import tech.ada.rflima.santander_coders.service.CriarUsuarioService;
import tech.ada.rflima.santander_coders.service.ObterUsuarioPorFiltroService;
import tech.ada.rflima.santander_coders.service.ObterUsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final ObterUsuarioService obterUsuarioService;
    private final CriarUsuarioService criarUsuarioService;
    private final ObterUsuarioPorFiltroService obterUsuarioPorFiltroService;

    public UsuarioController(ObterUsuarioService obterUsuarioService, CriarUsuarioService criarUsuarioService, ObterUsuarioPorFiltroService obterUsuarioPorFiltroService) {
        this.obterUsuarioService = obterUsuarioService;
        this.criarUsuarioService = criarUsuarioService;
        this.obterUsuarioPorFiltroService = obterUsuarioPorFiltroService;
    }

    @GetMapping("/{id}")
    public Usuario obterUsuarioPorId(@PathVariable Long id) {
        return obterUsuarioService.execute(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return criarUsuarioService.executar(usuario);
    }

    @GetMapping
    public List<Usuario> obterUsuariosPorFiltro(@RequestParam String nome) {
        return obterUsuarioPorFiltroService.obterUsuariosPorNomeContendo(nome);
    }

    @GetMapping("/cpf")
    public Usuario obterUsuariosPorCpf(@RequestParam String cpf) {
        return obterUsuarioPorFiltroService.obterUsuarioPorCpf(cpf);
    }
}



