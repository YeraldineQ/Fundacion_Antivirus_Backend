package com.fundacionantivirus.backend.repository;

import com.fundacionantivirus.backend.dto.FiltrarOportunidadesDTO;
import com.fundacionantivirus.backend.model.Oportunidad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomInstitucionesOportunidadesRepositoryImpl implements CustomInstitucionesOportunidadesRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Oportunidad> filtrarOportunidades(FiltrarOportunidadesDTO filtrarOportunidadesDTO) {
        return List.of();
    }
}
