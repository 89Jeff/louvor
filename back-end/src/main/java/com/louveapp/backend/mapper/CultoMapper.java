package com.louveapp.backend.mapper;

import com.louveapp.backend.dto.CultoDTO;
import com.louveapp.backend.dto.NovoCultoDTO;
import com.louveapp.backend.model.Culto;
import java.util.stream.Collectors;

public class CultoMapper {

    public static CultoDTO toDTO(Culto culto) {
        return CultoDTO.builder()
                .nome(culto.getNome())
                .local(culto.getLocal())
                .dataHora(culto.getDataHora())
                .repertorio(
                    culto.getRepertorio().stream()
                        .map(MusicaMapper::toDTO)
                        .collect(Collectors.toSet())
                )
                .build();
    }

    public static Culto toEntity(NovoCultoDTO dto) {
        return Culto.builder()
                .nome(dto.getNome())
                .local(dto.getLocal())
                .dataHora(dto.getDataHora())
                .build();
    }
}
