package com.louveapp.backend.controller;

import com.louveapp.backend.model.Culto;
import com.louveapp.backend.model.Escala;
import com.louveapp.backend.service.CultoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/cultos")
@RequiredArgsConstructor
public class CultoController {

    private final CultoService cultoService;

    @GetMapping
    public ResponseEntity<List<Culto>> listarCultos() {
        return ResponseEntity.ok(cultoService.listarCultosFuturos());
    }

    @GetMapping("/minhas-escalas")
    public ResponseEntity<List<Escala>> listarMinhasEscalas() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        // Aqui ideal seria pegar usuário pelo email e passar o ID
        // Para simplificar, vamos criar um método no service que recebe email

        // Vou ajustar serviço pra usar email:
        List<Escala> escalas = cultoService.listarEscalasUsuarioPorEmail(email);
        return ResponseEntity.ok(escalas);
    }

    @PostMapping("/confirmar/{escalaId}")
    public ResponseEntity<String> confirmarPresenca(@PathVariable Long escalaId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        boolean confirmado = cultoService.confirmarPresencaPorEmail(escalaId, email);
        if (confirmado) {
            return ResponseEntity.ok("Presença confirmada");
        } else {
            return ResponseEntity.badRequest().body("Não foi possível confirmar a presença");
        }
    }

    @PostMapping("/{cultoId}/musicas/{musicaId}")
    public ResponseEntity<Culto> adicionarMusicaAoCulto(
            @PathVariable Long cultoId,
            @PathVariable Long musicaId) {
            return ResponseEntity.ok(cultoService.adicionarMusicaAoCulto(cultoId, musicaId));
    }

    @DeleteMapping("/{cultoId}/musicas/{musicaId}")
    public ResponseEntity<Culto> removerMusicaDoCulto(
           @PathVariable Long cultoId,
           @PathVariable Long musicaId) {
            return ResponseEntity.ok(cultoService.removerMusicaDoCulto(cultoId, musicaId));
        }
}