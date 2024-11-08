package com.fundacionantivirus.backend.service;

import com.fundacionantivirus.backend.model.*;
import com.fundacionantivirus.backend.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OportunidadService {

    @Autowired
    private OportunidadRepository repository;

    @Autowired
    private TipoOportunidadRepository tipoOportunidadRepository;

    @Autowired
    private EstadoOportunidadRepository estadoOportunidadRepository;

    @Autowired
    private InformacionOportunidadRepository informacionOportunidadRepository;

    @Autowired
    private CategoriaOportunidadRepository categoriaOportunidadRepository;

    public List<Oportunidad> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<Oportunidad> create(Oportunidad oportunidad, Long idTipo, Long idEstado, Long idInformacion, Long idCategoria) {

        TipoOportunidad tipoOportunidad = tipoOportunidadRepository.findById(idTipo)
        .orElseThrow(() -> new RuntimeException("tipo no encontrada"));

        EstadoOportunidad estadoOportunidad = estadoOportunidadRepository.findById(idEstado)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        InformacionOportunidad informacionOportunidad = informacionOportunidadRepository.findById(idInformacion)
                .orElseThrow(() -> new RuntimeException("Información no encontrada"));

        CategoriaOportinidad categoriaOportinidad = categoriaOportunidadRepository.findById(idCategoria)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        oportunidad.setTipoOportunidad(tipoOportunidad);
        oportunidad.setEstadoOportunidad(estadoOportunidad);
        oportunidad.setInformacionOportunidad(informacionOportunidad);
        oportunidad.setCategoriaOportinidad(categoriaOportinidad);
        Oportunidad newOportunidad = repository.save(oportunidad);
        return ResponseEntity.ok(newOportunidad);
    }

    public Oportunidad update(Long id, Oportunidad oportunidad) {
        Oportunidad existing = repository.findById(id).orElseThrow();
        existing.setDescripcion(oportunidad.getDescripcion());
        existing.setTipoOportunidad(oportunidad.getTipoOportunidad());
        existing.setEstadoOportunidad(oportunidad.getEstadoOportunidad());
        existing.setInformacionOportunidad(oportunidad.getInformacionOportunidad());
        existing.setCategoriaOportinidad(oportunidad.getCategoriaOportinidad());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
