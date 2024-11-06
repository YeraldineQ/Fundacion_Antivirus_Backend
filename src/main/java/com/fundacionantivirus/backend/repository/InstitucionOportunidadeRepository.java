package com.fundacionantivirus.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundacionantivirus.backend.model.InstitucionOportunidades;

@Repository
public interface InstitucionOportunidadeRepository extends JpaRepository<InstitucionOportunidades, Long> {

}
