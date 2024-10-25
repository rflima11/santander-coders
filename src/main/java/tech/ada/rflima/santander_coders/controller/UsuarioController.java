package tech.ada.rflima.santander_coders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.ada.rflima.santander_coders.model.Usuario;
import tech.ada.rflima.santander_coders.service.CriarUsuarioService;
import tech.ada.rflima.santander_coders.service.ObterUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final ObterUsuarioService obterUsuarioService;
    private final CriarUsuarioService criarUsuarioService;

    public UsuarioController(ObterUsuarioService obterUsuarioService, CriarUsuarioService criarUsuarioService) {
        this.obterUsuarioService = obterUsuarioService;
        this.criarUsuarioService = criarUsuarioService;
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
}



