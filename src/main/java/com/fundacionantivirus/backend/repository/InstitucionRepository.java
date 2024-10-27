package com.fundacionantivirus.backend.repository;


import com.fundacionantivirus.backend.model.Institucion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitucionRepository extends JpaRepository<Institucion, Long> {
}

