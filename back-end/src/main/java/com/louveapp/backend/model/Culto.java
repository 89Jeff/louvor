package com.louveapp.backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Culto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDateTime dataHora;

    private String local;

    @OneToMany(mappedBy = "culto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Escala> escalas;

    @ManyToMany
    @JoinTable(
    name = "culto_musicas",
    joinColumns = @JoinColumn(name = "culto_id"),
    inverseJoinColumns = @JoinColumn(name = "musica_id")
    )
    private Set<Musica> repertorio;
}