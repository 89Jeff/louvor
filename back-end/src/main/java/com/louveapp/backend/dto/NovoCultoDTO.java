package com.louveapp.backend.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NovoCultoDTO {
    private String nome;
    private String local;
    private LocalDateTime dataHora;
}