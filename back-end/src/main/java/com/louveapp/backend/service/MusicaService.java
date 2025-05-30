package com.louveapp.backend.service;

import com.louveapp.backend.model.Musica;
import com.louveapp.backend.repository.MusicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MusicaService {

    private final MusicaRepository musicaRepository;

    public List<Musica> listarTodas() {
        return musicaRepository.findAll();
    }

    public Musica salvar(Musica musica) {
        return musicaRepository.save(musica);
    }

    public void deletar(Long id) {
        musicaRepository.deleteById(id);
    }

    public Musica atualizar(Long id, Musica nova) {
        Musica existente = musicaRepository.findById(id).orElseThrow();
        existente.setTitulo(nova.getTitulo());
        existente.setAutor(nova.getAutor());
        existente.setLinkYoutube(nova.getLinkYoutube());
        existente.setLetra(nova.getLetra());
        existente.setTom(nova.getTom());
        return musicaRepository.save(existente);
   }
}