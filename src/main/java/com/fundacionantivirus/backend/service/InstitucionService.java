package com.fundacionantivirus.backend.service;

import com.fundacionantivirus.backend.model.Institucion;
import com.fundacionantivirus.backend.repository.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitucionService {

    @Autowired
    private InstitucionRepository repository;

    public List<Institucion> getAll() {
        return repository.findAll();
    }

    public Institucion create(Institucion institucion) {
        return repository.save(institucion);
    }

    public Institucion update(Long id, Institucion institucion) {
        Institucion existing = repository.findById(id).orElseThrow();
        existing.setNombre(institucion.getNombre());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
