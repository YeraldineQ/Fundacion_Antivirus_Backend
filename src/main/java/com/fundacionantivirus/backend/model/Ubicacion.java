package com.fundacionantivirus.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String region;

    @OneToMany(mappedBy = "idRegion", cascade = CascadeType.REMOVE)
    private List<Institucion> institucion;

    // Getters y setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}

