package com.louveapp.backend.controller;

import com.louveapp.backend.dto.MusicaDTO;
import com.louveapp.backend.dto.NovaMusicaDTO;
import com.louveapp.backend.mapper.MusicaMapper;
import com.louveapp.backend.model.Musica;
import com.louveapp.backend.service.MusicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/musicas")
@RequiredArgsConstructor
public class MusicaController {

    private final MusicaService musicaService;

    @GetMapping
    public ResponseEntity<List<MusicaDTO>> listar() {
    List<MusicaDTO> musicas = musicaService.listarTodas()
        .stream().map(MusicaMapper::toDTO).toList();
    return ResponseEntity.ok(musicas);
    }

    @PostMapping
    public ResponseEntity<MusicaDTO> salvar(@RequestBody NovaMusicaDTO dto) {
    Musica salva = musicaService.salvar(MusicaMapper.toEntity(dto));
    return ResponseEntity.ok(MusicaMapper.toDTO(salva));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        musicaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusicaDTO> atualizar(@PathVariable Long id, @RequestBody NovaMusicaDTO dto) {
    Musica atualizada = musicaService.atualizar(id, MusicaMapper.toEntity(dto));
    return ResponseEntity.ok(MusicaMapper.toDTO(atualizada));
    }
}