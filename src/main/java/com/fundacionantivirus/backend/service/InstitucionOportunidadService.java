package com.fundacionantivirus.backend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fundacionantivirus.backend.model.Institucion;
import com.fundacionantivirus.backend.model.InstitucionOportunidades;
import com.fundacionantivirus.backend.model.Oportunidad;
import com.fundacionantivirus.backend.repository.InstitucionOportunidadeRepository;
import com.fundacionantivirus.backend.repository.InstitucionRepository;
import com.fundacionantivirus.backend.repository.OportunidadRepository;

@Service
public class InstitucionOportunidadService {
    private InstitucionOportunidadeRepository institucionOportunidadeRepository;
    private InstitucionRepository institucionRepository;
    private OportunidadRepository oportunidadRepository;

    public InstitucionOportunidadService(
        InstitucionOportunidadeRepository institucionOportunidadeRepository,
        InstitucionRepository institucionRepository,
        OportunidadRepository oportunidadRepository
    ){
        this.institucionOportunidadeRepository = institucionOportunidadeRepository;
        this.institucionRepository = institucionRepository;
        this.oportunidadRepository = oportunidadRepository;
    }   

    public ResponseEntity<Object> createInstitucionOportunidades(Long idInstitucion, Long idOportunidad){

        Institucion institucion = institucionRepository.findById(idInstitucion)
        .orElseThrow(() -> new RuntimeException("institucion no encontrada"));

        Oportunidad oportunidad = oportunidadRepository.findById(idOportunidad)
        .orElseThrow(() -> new RuntimeException("oportunidad no encontrada"));

        InstitucionOportunidades institucionOportunidades = new InstitucionOportunidades();
        institucionOportunidades.setInstitucion(institucion);
        institucionOportunidades.setOportunidad(oportunidad);

        InstitucionOportunidades newOportunity = institucionOportunidadeRepository.save(institucionOportunidades);
        
        return ResponseEntity.ok(newOportunity);     
    }

}
