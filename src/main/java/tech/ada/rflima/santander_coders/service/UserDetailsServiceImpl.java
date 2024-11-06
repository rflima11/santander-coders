package tech.ada.rflima.santander_coders.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import tech.ada.rflima.santander_coders.dto.UserDetailsInfoDTO;
import tech.ada.rflima.santander_coders.model.Usuario;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ObterUsuarioEmailService obterUsuarioEmailService;

    public UserDetailsServiceImpl(ObterUsuarioEmailService obterUsuarioEmailService) {
        this.obterUsuarioEmailService = obterUsuarioEmailService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuarioEncontrado = obterUsuarioEmailService.execute(username);
        return new UserDetailsInfoDTO(usuarioEncontrado);
    }
}
