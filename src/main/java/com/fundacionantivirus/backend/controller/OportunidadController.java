package com.fundacionantivirus.backend.controller;


import com.fundacionantivirus.backend.model.Oportunidad;
import com.fundacionantivirus.backend.service.OportunidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oportunidades")
public class OportunidadController {

    @Autowired
    private OportunidadService oportunidadService;

    @GetMapping
    public List<Oportunidad> getAll() {
        return oportunidadService.getAll();
    }

    @PostMapping("/{idTipo}")
    public ResponseEntity<Oportunidad> create(@RequestBody Oportunidad oportunidad,@PathVariable Long idTipo, @PathVariable Long idEstado, @PathVariable Long idInformacion, @PathVariable Long idCategoria) {
        return oportunidadService.create(oportunidad, idTipo, idEstado, idInformacion, idCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Oportunidad> update(@PathVariable Long id, @RequestBody Oportunidad oportunidad) {
        return ResponseEntity.ok(oportunidadService.update(id, oportunidad));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        oportunidadService.delete(id);
    }
}

