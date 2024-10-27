package com.fundacionantivirus.backend.model;

import jakarta.persistence.*;

@Entity
public class Oportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "tipo_oportunidad_id")
    private TipoOportunidad tipoOportunidad;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoOportunidad getTipoOportunidad() {
        return tipoOportunidad;
    }

    public void setTipoOportunidad(TipoOportunidad tipoOportunidad) {
        this.tipoOportunidad = tipoOportunidad;
    }
}

