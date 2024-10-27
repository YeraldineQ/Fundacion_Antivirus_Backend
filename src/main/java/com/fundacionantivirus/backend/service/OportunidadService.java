package com.fundacionantivirus.backend.service;

import com.fundacionantivirus.backend.model.Oportunidad;
import com.fundacionantivirus.backend.repository.OportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OportunidadService {

    @Autowired
    private OportunidadRepository repository;

    public List<Oportunidad> getAll() {
        return repository.findAll();
    }

    public Oportunidad create(Oportunidad oportunidad) {
        return repository.save(oportunidad);
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
