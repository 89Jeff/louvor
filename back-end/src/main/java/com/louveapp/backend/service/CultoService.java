package com.louveapp.backend.service;

import com.louveapp.backend.model.Culto;
import com.louveapp.backend.model.Escala;
import com.louveapp.backend.model.Musica;
import com.louveapp.backend.model.Usuario;
import com.louveapp.backend.repository.CultoRepository;
import com.louveapp.backend.repository.EscalaRepository;
import com.louveapp.backend.repository.MusicaRepository;
import com.louveapp.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CultoService {

    private final CultoRepository cultoRepository;
    private final EscalaRepository escalaRepository;
    private final UsuarioRepository usuarioRepository;
    private final MusicaRepository musicaRepository;

    public List<Culto> listarCultosFuturos() {
        return cultoRepository.findByDataHoraAfterOrderByDataHoraAsc(LocalDateTime.now());
    }

    public List<Escala> listarEscalasUsuarioPorEmail(String email) {
         Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow();
         return escalaRepository.findByUsuarioAndConfirmadoPresencaFalse(usuario);
    }

    public boolean confirmarPresencaPorEmail(Long escalaId, String email) {
         Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow();
         Escala escala = escalaRepository.findByIdAndUsuario(escalaId, usuario).orElseThrow();
         escala.setConfirmadoPresenca(true);
          escalaRepository.save(escala);
    return true;
    }

    public Culto adicionarMusicaAoCulto(Long cultoId, Long musicaId) {
        Culto culto = cultoRepository.findById(cultoId).orElseThrow();
        Musica musica = musicaRepository.findById(musicaId).orElseThrow();
        culto.getRepertorio().add(musica);
        return cultoRepository.save(culto);
    }

    public Culto removerMusicaDoCulto(Long cultoId, Long musicaId) {
        Culto culto = cultoRepository.findById(cultoId).orElseThrow();
        Musica musica = musicaRepository.findById(musicaId).orElseThrow();
        culto.getRepertorio().remove(musica);
        return cultoRepository.save(culto);
    }
}