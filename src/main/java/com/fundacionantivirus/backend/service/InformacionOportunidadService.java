package com.fundacionantivirus.backend.service;


import com.fundacionantivirus.backend.model.InformacionOportunidad;
import com.fundacionantivirus.backend.repository.InformacionOportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class InformacionOportunidadService {
    @Autowired
    private InformacionOportunidadRepository repository;

    public List<InformacionOportunidad> getAll() {
        return repository.findAll();
    }

    public InformacionOportunidad create(InformacionOportunidad informacionOportunidad) {
        return repository.save(informacionOportunidad);
    }

    public InformacionOportunidad getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Información no encontrada"));
    }

}
