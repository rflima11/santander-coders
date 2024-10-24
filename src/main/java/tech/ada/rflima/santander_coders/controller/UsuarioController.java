package tech.ada.rflima.santander_coders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.ada.rflima.santander_coders.model.Usuario;
import tech.ada.rflima.santander_coders.service.ObterUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

//    @Autowired
//    private ObterUsuarioService service;

    private final ObterUsuarioService service;

    public UsuarioController(ObterUsuarioService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Usuario obterUsuarioPorId(@PathVariable Long id) {
        return service.execute(id);
    }


}



