package com.louveapp.backend.mapper;

import com.louveapp.backend.dto.EscalaDTO;
import com.louveapp.backend.model.Escala;

public class EscalaMapper {
    
    public static EscalaDTO toDTO(Escala escala) {
        return EscalaDTO.builder()                
                .id(escala.getId())
                .cultoId(escala.getCulto().getId())
                .nomeUsuario(escala.getUsuario().getNome())
                .emailUsuario(escala.getUsuario().getEmail())
                .funcao(escala.getFuncao())
                .confirmadoPresenca(escala.isConfirmadoPresenca())
                .build();
    }
}
