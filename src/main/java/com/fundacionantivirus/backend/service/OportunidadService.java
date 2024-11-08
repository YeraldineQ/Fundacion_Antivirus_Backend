package com.fundacionantivirus.backend.service;

import com.fundacionantivirus.backend.model.EstadoOportunidad;
import com.fundacionantivirus.backend.model.InformacionOportunidad;
import com.fundacionantivirus.backend.model.Oportunidad;
import com.fundacionantivirus.backend.model.TipoOportunidad;
import com.fundacionantivirus.backend.repository.EstadoOportunidadRepository;
import com.fundacionantivirus.backend.repository.InformacionOportunidadRepository;
import com.fundacionantivirus.backend.repository.OportunidadRepository;
import com.fundacionantivirus.backend.repository.TipoOportunidadRepository;

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

    public List<Oportunidad> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<Oportunidad> create(Oportunidad oportunidad, Long idTipo, Long idEstado, Long idInformacion) {

        TipoOportunidad tipoOportunidad = tipoOportunidadRepository.findById(idTipo)
        .orElseThrow(() -> new RuntimeException("tipo no encontrada"));

        EstadoOportunidad estadoOportunidad = estadoOportunidadRepository.findById(idEstado)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        InformacionOportunidad informacionOportunidad = informacionOportunidadRepository.findById(idInformacion)
                .orElseThrow(() -> new RuntimeException("Información no encontrada"));

        oportunidad.setTipoOportunidad(tipoOportunidad);
        oportunidad.setEstadoOportunidad(estadoOportunidad);
        oportunidad.setInformacionOportunidad(informacionOportunidad);
        Oportunidad newOportunidad = repository.save(oportunidad);
        return ResponseEntity.ok(newOportunidad);
    }

    public Oportunidad update(Long id, Oportunidad oportunidad) {
        Oportunidad existing = repository.findById(id).orElseThrow();
        existing.setDescripcion(oportunidad.getDescripcion());
        existing.setTipoOportunidad(oportunidad.getTipoOportunidad());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
