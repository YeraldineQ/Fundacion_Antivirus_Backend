package com.fundacionantivirus.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UserController {
    @GetMapping("/perfil")
    public ResponseEntity<String> obtenerConfiguracion() {
        return ResponseEntity.ok("perfil de usuario registrado.");
    }
}
