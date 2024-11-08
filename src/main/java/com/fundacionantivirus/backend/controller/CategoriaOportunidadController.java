package com.fundacionantivirus.backend.controller;

import com.fundacionantivirus.backend.model.CategoriaOportinidad;
import com.fundacionantivirus.backend.service.CategoriaOportunidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria-oportunidades")
public class CategoriaOportunidadController {
    @Autowired
    private CategoriaOportunidadService categoriaOportunidadService;

    @GetMapping
    public List<CategoriaOportinidad> getAll() {
        return categoriaOportunidadService.getAll();
    }

    @PostMapping
    public CategoriaOportinidad create(@RequestBody CategoriaOportinidad categoriaOportinidad) {
        return categoriaOportunidadService.create(categoriaOportinidad);
    }

    @GetMapping("/{id}")
    public CategoriaOportinidad getById(@PathVariable Long id) {
        return categoriaOportunidadService.getById(id);
    }
}
