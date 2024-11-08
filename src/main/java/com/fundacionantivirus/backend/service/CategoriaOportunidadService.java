package com.fundacionantivirus.backend.service;

import com.fundacionantivirus.backend.model.CategoriaOportinidad;
import com.fundacionantivirus.backend.repository.CategoriaOportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaOportunidadService {
    @Autowired
    private CategoriaOportunidadRepository repository;

    public List<CategoriaOportinidad> getAll() {
        return repository.findAll();
    }

    public CategoriaOportinidad create(CategoriaOportinidad categoriaOportinidad) {
        return repository.save(categoriaOportinidad);
    }

    public CategoriaOportinidad getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }
}
