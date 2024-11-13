package com.fundacionantivirus.backend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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
    private Categoria categoriaOportinidad;

    @ManyToMany(fetch = FetchType.EAGER)@JoinTable(name = "institucion_oportunidad",
            joinColumns = @JoinColumn(name = "institucion_id"),
            inverseJoinColumns = @JoinColumn(name = "oportunidad_id"))
    private Set<Institucion> institucionOportunidad = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)@JoinTable(name = "user_oportunidad",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "oportunidad_id"))
    private Set<User> userOportunidad = new HashSet<>();

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

    public Categoria getCategoriaOportinidad() { return categoriaOportinidad;}

    public void setCategoriaOportinidad(Categoria categoriaOportinidad) { this.categoriaOportinidad = categoriaOportinidad;}

    public Set<Institucion> getInstitucionOportunidad() {
        return institucionOportunidad;
    }

    public void setInstitucionOportunidad(Set<Institucion> institucionOportunidad) {
        this.institucionOportunidad = institucionOportunidad;
    }

    public Set<User> getUserOportunidad() {
        return userOportunidad;
    }

    public void setUserOportunidad(Set<User> userOportunidad) {
        this.userOportunidad = userOportunidad;
    }
}

