package tech.ada.rflima.santander_coders.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.rflima.santander_coders.dto.request.AuthRequestDTO;
import tech.ada.rflima.santander_coders.dto.response.AuthResponseDTO;
import tech.ada.rflima.santander_coders.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody @Valid AuthRequestDTO request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}

