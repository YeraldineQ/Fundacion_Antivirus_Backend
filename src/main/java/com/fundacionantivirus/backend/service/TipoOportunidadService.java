package com.fundacionantivirus.backend.service;

import com.fundacionantivirus.backend.model.TipoOportunidad;
import com.fundacionantivirus.backend.repository.TipoOportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoOportunidadService {

    @Autowired
    private TipoOportunidadRepository repository;

    public List<TipoOportunidad> getAll() {
        return repository.findAll();
    }

    public TipoOportunidad create(TipoOportunidad tipoOportunidad) {
        return repository.save(tipoOportunidad);
    }

    public TipoOportunidad update(Long id, TipoOportunidad tipoOportunidad) {
        TipoOportunidad existing = repository.findById(id).orElseThrow();
        existing.setNombre(tipoOportunidad.getNombre());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
