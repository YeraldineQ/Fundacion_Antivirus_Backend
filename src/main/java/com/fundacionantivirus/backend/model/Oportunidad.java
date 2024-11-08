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

    @ManyToOne
    @JoinColumn(name = "estado_oportunidad_id")
    private EstadoOportunidad estadoOportunidad;

    @ManyToOne
    @JoinColumn(name = "informacion_oportunidad_id")
    private InformacionOportunidad informacionOportunidad;

    @ManyToOne
    @JoinColumn(name = "categoria_oportunidad_id")
    private CategoriaOportinidad categoriaOportinidad;

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

    public EstadoOportunidad getEstadoOportunidad() { return estadoOportunidad;}

    public void setEstadoOportunidad(EstadoOportunidad estadoOportunidad) { this.estadoOportunidad = estadoOportunidad;}

    public InformacionOportunidad getInformacionOportunidad() { return informacionOportunidad;}

    public void setInformacionOportunidad(InformacionOportunidad informacionOportunidad) { this.informacionOportunidad = informacionOportunidad;}

    public CategoriaOportinidad getCategoriaOportinidad() { return categoriaOportinidad;}

    public void setCategoriaOportinidad(CategoriaOportinidad categoriaOportinidad) { this.categoriaOportinidad = categoriaOportinidad;}
}

