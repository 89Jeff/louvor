package com.louveapp.backend.controller;

import com.louveapp.backend.dto.EscalaDTO;
import com.louveapp.backend.dto.NovaEscalaDTO;
import com.louveapp.backend.mapper.EscalaMapper;
import com.louveapp.backend.model.Escala;
import com.louveapp.backend.service.EscalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/escalas")
@RequiredArgsConstructor
public class EscalaController {

    private final EscalaService escalaService;

    @GetMapping
    public ResponseEntity<List<EscalaDTO>> listar() {
        List<Escala> escalas = escalaService.listarTodas();
        List<EscalaDTO> dtos = escalas.stream()
                .map(EscalaMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<EscalaDTO> criar(@RequestBody NovaEscalaDTO dto) {
        Escala salva = escalaService.criarEscala(dto);
        return ResponseEntity.ok(EscalaMapper.toDTO(salva));
    }

    @PostMapping("/{id}/confirmar")
    public ResponseEntity<EscalaDTO> confirmarPresenca(@PathVariable Long id) {
        Escala confirmada = escalaService.confirmarPresenca(id);
        return ResponseEntity.ok(EscalaMapper.toDTO(confirmada));
    }
}