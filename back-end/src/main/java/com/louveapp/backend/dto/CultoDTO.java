package com.louveapp.backend.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CultoDTO {
    private Long id;
    private String nome;
    private String local;
    private LocalDateTime dataHora;
    private Set<MusicaDTO> repertorio;
}