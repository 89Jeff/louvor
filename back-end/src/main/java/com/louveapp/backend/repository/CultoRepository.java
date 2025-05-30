package com.louveapp.backend.repository;

import com.louveapp.backend.model.Culto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CultoRepository extends JpaRepository<Culto, Long> {
    List<Culto> findByDataHoraAfterOrderByDataHoraAsc(LocalDateTime dataHora);
}