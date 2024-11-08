package com.fundacionantivirus.backend.controller;


import com.fundacionantivirus.backend.model.InformacionOportunidad;
import com.fundacionantivirus.backend.service.InformacionOportunidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/informacion-oportunidades")
public class InformacionOportunidadController {

    @Autowired
    private InformacionOportunidadService informacionOportunidadService;

    @GetMapping
    public List<InformacionOportunidad> getAll() {
        return informacionOportunidadService.getAll();
    }

    @PostMapping
    public InformacionOportunidad create(@RequestBody InformacionOportunidad informacionOportunidad) {
        return informacionOportunidadService.create(informacionOportunidad);
    }

    @GetMapping("/{id}")
    public InformacionOportunidad getById(@PathVariable Long id) {
        return informacionOportunidadService.getById(id);
    }
}
