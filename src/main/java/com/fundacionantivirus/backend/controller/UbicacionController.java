package com.fundacionantivirus.backend.controller;


import com.fundacionantivirus.backend.model.Ubicacion;
import com.fundacionantivirus.backend.repository.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ubicaciones")
public class UbicacionController {

    @Autowired
    private UbicacionRepository repository;

    @GetMapping
    public List<Ubicacion> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Ubicacion create(@RequestBody Ubicacion ubicacion) {
        return repository.save(ubicacion);
    }

    @PutMapping("/{id}")
    public Ubicacion update(@PathVariable Long id, @RequestBody Ubicacion ubicacion) {
        Ubicacion existing = repository.findById(id).orElseThrow();
        existing.setRegion(ubicacion.getRegion());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
