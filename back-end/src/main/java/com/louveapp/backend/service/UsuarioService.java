package com.louveapp.backend.service;

import com.louveapp.backend.dto.NovoUsuarioDTO;
import com.louveapp.backend.model.Perfil;
import com.louveapp.backend.model.Usuario;
import com.louveapp.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public Usuario cadastrarUsuario(NovoUsuarioDTO dto) {
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }

        Usuario usuario = Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(passwordEncoder.encode(dto.getSenha()))
                .perfil(Perfil.valueOf(dto.getPerfil()))
                .ativo(true)
                .build();

        return usuarioRepository.save(usuario);
    }
}