package com.louveapp.backend.controller;

import com.louveapp.backend.dto.NovoUsuarioDTO;
import com.louveapp.backend.model.Usuario;
import com.louveapp.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Só ADMIN pode cadastrar novos usuários
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody NovoUsuarioDTO dto) {
        Usuario usuario = usuarioService.cadastrarUsuario(dto);
        return ResponseEntity.ok(usuario);
    }
}