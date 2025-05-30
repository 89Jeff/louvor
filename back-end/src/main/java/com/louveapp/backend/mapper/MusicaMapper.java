package com.louveapp.backend.mapper;

import com.louveapp.backend.dto.MusicaDTO;
import com.louveapp.backend.dto.NovaMusicaDTO;
import com.louveapp.backend.model.Musica;

public class MusicaMapper {

    public static MusicaDTO toDTO(Musica musica) {
        return MusicaDTO.builder()
                
                //.id(musica.getId())
                .titulo(musica.getTitulo())
                .autor(musica.getAutor())
                .linkYoutube(musica.getLinkYoutube())
                .letra(musica.getLetra())
                .tom(musica.getTom())
                .build();
    }

    public static Musica toEntity(NovaMusicaDTO dto) {
        return Musica.builder()
                .titulo(dto.getTitulo())
                .autor(dto.getAutor())
                .linkYoutube(dto.getLinkYoutube())
                .letra(dto.getLetra())
                .tom(dto.getTom())
                .build();
    }
}