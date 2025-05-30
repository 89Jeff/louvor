package com.louveapp.backend.dto;


import lombok.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NovaEscalaDTO {
    private Long cultoId;
    private Long usuarioId;
    private String funcao;
}