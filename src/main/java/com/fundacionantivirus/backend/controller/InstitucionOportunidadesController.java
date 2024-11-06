package com.fundacionantivirus.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundacionantivirus.backend.service.InstitucionOportunidadService;

@RestController
@RequestMapping("api/institucion-oportunidades")
public class InstitucionOportunidadesController {

    @Autowired
    private InstitucionOportunidadService institucionOportunidadService;

    @PostMapping("/{idInstitucion}/{idOportunidad}")
    public ResponseEntity<Object> createOportunidad(@PathVariable Long idInstitucion, 
                                                    @PathVariable Long idOportunidad){
        return institucionOportunidadService.createInstitucionOportunidades(idInstitucion, idOportunidad);
    }
}
