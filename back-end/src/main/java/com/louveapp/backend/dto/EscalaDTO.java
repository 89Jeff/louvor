package com.louveapp.backend.dto;

import lombok.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EscalaDTO {
    private Long id;
    private String nomeUsuario;
    private String emailUsuario;
    private String funcao;
    private boolean confirmadoPresenca;
    private Long cultoId;
}