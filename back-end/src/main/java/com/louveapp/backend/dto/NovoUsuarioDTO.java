package com.louveapp.backend.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NovoUsuarioDTO {
    private String nome;
    private String email;
    private String senha;
    private String perfil; // ADMIN, MINISTRO ou MUSICO
}