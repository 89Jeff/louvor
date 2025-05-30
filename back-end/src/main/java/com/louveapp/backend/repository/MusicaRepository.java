package com.louveapp.backend.repository;

import com.louveapp.backend.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
}