package com.louveapp.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NovaMusicaDTO {
    private String titulo;
    private String autor;
    private String linkYoutube;
    private String letra;
    private String tom;
}