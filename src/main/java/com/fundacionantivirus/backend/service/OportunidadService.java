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
    private CategoriaRepository categoriaOportunidadRepository;

    public List<Oportunidad> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<Oportunidad> create(Oportunidad oportunidad) {


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
