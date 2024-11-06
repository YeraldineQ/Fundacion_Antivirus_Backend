package com.fundacionantivirus.backend.service;

import com.fundacionantivirus.backend.model.Oportunidad;
import com.fundacionantivirus.backend.model.TipoOportunidad;
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

    public List<Oportunidad> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<Oportunidad> create(Oportunidad oportunidad, Long idTipo) {

        TipoOportunidad tipoOportunidad = tipoOportunidadRepository.findById(idTipo)
        .orElseThrow(() -> new RuntimeException("tipo no encontrada"));
        oportunidad.setTipoOportunidad(tipoOportunidad);
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
