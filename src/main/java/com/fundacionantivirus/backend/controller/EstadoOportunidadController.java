package com.fundacionantivirus.backend.controller;


import com.fundacionantivirus.backend.model.EstadoOportunidad;
import com.fundacionantivirus.backend.service.EstadoOportunidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado-oportunidades")
public class EstadoOportunidadController {

    @Autowired
    private EstadoOportunidadService estadoOportunidadService;

    @GetMapping
    public List<EstadoOportunidad> getAll() {
        return estadoOportunidadService.getAll();
    }

    @PostMapping
    public EstadoOportunidad create(@RequestBody EstadoOportunidad estadoOportunidad) {
        return estadoOportunidadService.create(estadoOportunidad);
    }

    @GetMapping("/{id}")
    public EstadoOportunidad getById(@PathVariable Long id) {
        return estadoOportunidadService.getById(id);
    }
}
