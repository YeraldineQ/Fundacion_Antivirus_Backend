package com.fundacionantivirus.backend.service;

import com.fundacionantivirus.backend.model.EstadoOportunidad;
import com.fundacionantivirus.backend.repository.EstadoOportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoOportunidadService {

    @Autowired
    private EstadoOportunidadRepository repository;

    public List<EstadoOportunidad> getAll() {
        return repository.findAll();
    }

    public EstadoOportunidad create(EstadoOportunidad estadoOportunidad) {
        return repository.save(estadoOportunidad);
    }

    public EstadoOportunidad getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Estado no encontrado"));
    }
}
