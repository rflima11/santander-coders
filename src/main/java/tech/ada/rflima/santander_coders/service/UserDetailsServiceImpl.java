package tech.ada.rflima.santander_coders.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.ada.rflima.santander_coders.exceptions.UsuarioNaoEncontradoException;
import tech.ada.rflima.santander_coders.model.Usuario;
import tech.ada.rflima.santander_coders.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.encontrarPorEmail(username).orElseThrow(() -> new UsuarioNaoEncontradoException(
                "Login inválido"
        ));
        return User.withDefaultPasswordEncoder()
                .username(username)
                .password(user.getPassword())
                .roles("USER")
                .build();


    }
}
