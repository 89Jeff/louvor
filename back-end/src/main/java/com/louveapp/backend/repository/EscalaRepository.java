package com.louveapp.backend.repository;

import com.louveapp.backend.model.Escala;
import com.louveapp.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EscalaRepository extends JpaRepository<Escala, Long> {
    List<Escala> findByUsuarioAndConfirmadoPresencaFalse(Usuario usuario);
    Optional<Escala> findByIdAndUsuario(Long id, Usuario usuario);
}