package com.fundacionantivirus.backend.model;

import jakarta.persistence.*;

@Entity
public class EstadoOportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String estado; // Puede ser "activo" o "inactivo"

    // Constructor, Getters y Setters

    public EstadoOportunidad() {}

    public EstadoOportunidad(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
