package com.fundacionantivirus.backend.controller;


import com.fundacionantivirus.backend.model.Oportunidad;
import com.fundacionantivirus.backend.repository.OportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oportunidades")
public class OportunidadController {

    @Autowired
    private OportunidadRepository repository;

    @GetMapping
    public List<Oportunidad> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Oportunidad create(@RequestBody Oportunidad oportunidad) {
        return repository.save(oportunidad);
    }

    @PutMapping("/{id}")
    public Oportunidad update(@PathVariable Long id, @RequestBody Oportunidad oportunidad) {
        Oportunidad existing = repository.findById(id).orElseThrow();
        existing.setDescripcion(oportunidad.getDescripcion());
        existing.setTipoOportunidad(oportunidad.getTipoOportunidad());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

