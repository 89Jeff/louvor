package com.louveapp.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.louveapp.backend.model.Usuario;
import com.louveapp.backend.repository.UsuarioRepository;

@SpringBootTest
class LouveappBackendApplicationTests {

	 @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void testFindByEmail() {
        String emailTeste = "admin@louveapp.com";

        Optional<Usuario> userOptional = usuarioRepository.findByEmail(emailTeste);

        System.out.println("Usuário encontrado: " + userOptional);

        assertTrue(userOptional.isPresent(), "Usuário deve estar presente no banco");
        userOptional.ifPresent(user -> {
            assertEquals(emailTeste, user.getEmail(), "Email deve ser igual");
            System.out.println("Nome do usuário: " + user.getNome());
            System.out.println("Perfil do usuário: " + user.getPerfil());
        });
    }
}
