package com.fundacionantivirus.backend.repository;

import com.fundacionantivirus.backend.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
