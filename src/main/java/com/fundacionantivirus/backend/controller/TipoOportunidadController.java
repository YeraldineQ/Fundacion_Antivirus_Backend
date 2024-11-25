package com.fundacionantivirus.backend.controller;


import com.fundacionantivirus.backend.model.TipoOportunidad;
import com.fundacionantivirus.backend.repository.TipoOportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-oportunidades")
public class TipoOportunidadController {

    @Autowired
    private TipoOportunidadRepository repository;

    @GetMapping
    public List<TipoOportunidad> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public TipoOportunidad create(@RequestBody TipoOportunidad tipoOportunidad) {
        return repository.save(tipoOportunidad);
    }

    @PutMapping("/{id}")
    public TipoOportunidad update(@PathVariable Long id, @RequestBody TipoOportunidad tipoOportunidad) {
        TipoOportunidad existing = repository.findById(id).orElseThrow();
        existing.setNombre(tipoOportunidad.getNombre());
        existing.setUrl(tipoOportunidad.getUrl());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

