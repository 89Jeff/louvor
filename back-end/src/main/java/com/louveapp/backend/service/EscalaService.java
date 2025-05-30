package com.louveapp.backend.service;

import com.louveapp.backend.dto.NovaEscalaDTO;
import com.louveapp.backend.model.Culto;
import com.louveapp.backend.model.Escala;
import com.louveapp.backend.model.Usuario;
import com.louveapp.backend.repository.CultoRepository;
import com.louveapp.backend.repository.EscalaRepository;
import com.louveapp.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class EscalaService {

    private final EscalaRepository escalaRepository;
    private final UsuarioRepository usuarioRepository;
    private final CultoRepository cultoRepository;

    public List<Escala> listarTodas() {
        return escalaRepository.findAll();
    }

    public Escala criarEscala(NovaEscalaDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Culto culto = cultoRepository.findById(dto.getCultoId())
                .orElseThrow(() -> new RuntimeException("Culto não encontrado"));

        Escala escala = Escala.builder()
                .usuario(usuario)
                .culto(culto)
                .funcao(dto.getFuncao())
                .confirmadoPresenca(false)
                .build();

        return escalaRepository.save(escala);
    }

    public Escala confirmarPresenca(Long escalaId) {
        Escala escala = escalaRepository.findById(escalaId)
                .orElseThrow(() -> new RuntimeException("Escala não encontrada"));

        escala.setConfirmadoPresenca(true);
        return escalaRepository.save(escala);
    }
}