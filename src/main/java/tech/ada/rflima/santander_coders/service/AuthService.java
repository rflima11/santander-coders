package tech.ada.rflima.santander_coders.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import tech.ada.rflima.santander_coders.dto.request.AuthRequestDTO;
import tech.ada.rflima.santander_coders.dto.response.AuthResponseDTO;
import tech.ada.rflima.santander_coders.exceptions.UsuarioNaoEncontradoException;
import tech.ada.rflima.santander_coders.model.Usuario;
import tech.ada.rflima.santander_coders.repository.UsuarioRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;

    private final AuthenticationManager authenticationManager;

    public AuthService(JwtService jwtService, UsuarioRepository usuarioRepository, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponseDTO authenticate(AuthRequestDTO request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getUsername()).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado"));

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("nome", "Rodolfo");

        String token = jwtService.generateToken(usuario, extraClaims);
        return new AuthResponseDTO(token);
    }


}
