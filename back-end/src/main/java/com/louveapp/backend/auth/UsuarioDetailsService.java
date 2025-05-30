package com.louveapp.backend.auth;

import com.louveapp.backend.model.Usuario;
import com.louveapp.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    /*@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return new User(usuario.getEmail(), usuario.getSenha(),
                List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getPerfil().name())));
    }*/
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    System.out.println("Procurando usuário com email: " + email); // debug temporário

    Usuario usuario = usuarioRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

    return new User(usuario.getEmail(), usuario.getSenha(),
            List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getPerfil().name())));
    }
}
