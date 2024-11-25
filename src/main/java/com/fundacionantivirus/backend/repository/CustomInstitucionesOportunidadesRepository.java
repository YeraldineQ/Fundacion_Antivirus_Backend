package com.fundacionantivirus.backend.repository;

import com.fundacionantivirus.backend.dto.FiltrarOportunidadesDTO;
import com.fundacionantivirus.backend.model.Oportunidad;

import java.util.List;

public interface CustomInstitucionesOportunidadesRepository {
    List<Oportunidad> filtrarOportunidades(FiltrarOportunidadesDTO filtrarOportunidadesDTO);
}
