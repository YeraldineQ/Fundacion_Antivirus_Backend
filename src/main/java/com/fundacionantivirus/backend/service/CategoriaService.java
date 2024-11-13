package com.fundacionantivirus.backend.service;

import com.fundacionantivirus.backend.model.Categoria;
import com.fundacionantivirus.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> getAll() {
        return repository.findAll();
    }

    public Categoria create(Categoria categoriaOportinidad) {
        return repository.save(categoriaOportinidad);
    }

    public Categoria getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }
}
