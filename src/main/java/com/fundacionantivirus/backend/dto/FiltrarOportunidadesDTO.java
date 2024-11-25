package com.fundacionantivirus.backend.dto;

public class FiltrarOportunidadesDTO {
    private String nombre;
    private Long idRegion;
    private Long idCategoria;
    private Long idInstitucion;
    private String regionNombre;
    private String categoriaNombre;
    private String institucionNombre;
    private String url;

    public FiltrarOportunidadesDTO(String nombre, Long idRegion, Long idCategoria, Long idInstitucion, String regionNombre, String categoriaNombre, String institucionNombre, String url) {
        this.nombre = nombre;
        this.idRegion = idRegion;
        this.idCategoria = idCategoria;
        this.idInstitucion = idInstitucion;
        this.regionNombre = regionNombre;
        this.categoriaNombre = categoriaNombre;
        this.institucionNombre = institucionNombre;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Long idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getRegionNombre() {
        return regionNombre;
    }

    public void setRegionNombre(String regionNombre) {
        this.regionNombre = regionNombre;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public String getInstitucionNombre() {
        return institucionNombre;
    }

    public void setInstitucionNombre(String institucionNombre) {
        this.institucionNombre = institucionNombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
