package com.fundacionantivirus.backend.model;

import jakarta.persistence.*;

@Entity
public class InstitucionOportunidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "instituciones_id", referencedColumnName = "id")
    private Institucion institucion;

    @ManyToOne
    @JoinColumn(name = "Oportunidades_id", referencedColumnName = "id")
    private Oportunidad oportunidad;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public Oportunidad getOportunidad() {
        return oportunidad;
    }

    public void setOportunidad(Oportunidad oportunidad) {
        this.oportunidad = oportunidad;
    }

    
}
