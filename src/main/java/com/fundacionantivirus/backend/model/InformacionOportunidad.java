package com.fundacionantivirus.backend.model;

import jakarta.persistence.*;

@Entity
public class InformacionOportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String informacion;

    // Constructor, Getters y Setters

    public InformacionOportunidad() {}

    public InformacionOportunidad(String informacion) {
        this.informacion = informacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}

