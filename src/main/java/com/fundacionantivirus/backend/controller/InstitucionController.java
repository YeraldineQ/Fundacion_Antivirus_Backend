package com.fundacionantivirus.backend.controller;


import com.fundacionantivirus.backend.model.Institucion;
import com.fundacionantivirus.backend.repository.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instituciones")
public class InstitucionController {

    @Autowired
    private InstitucionRepository repository;

    @GetMapping
    public List<Institucion> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Institucion create(@RequestBody Institucion institucion) {
        return repository.save(institucion);
    }

    @PutMapping("/{id}")
    public Institucion update(@PathVariable Long id, @RequestBody Institucion institucion) {
        Institucion existing = repository.findById(id).orElseThrow();
        existing.setNombre(institucion.getNombre());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
