package com.fundacionantivirus.backend.model;

import jakarta.persistence.*;

@Entity
public class CategoriaOportinidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String categoria;

    // Constructor, Getters y Setters

    public CategoriaOportinidad() {}

    public CategoriaOportinidad(String categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
