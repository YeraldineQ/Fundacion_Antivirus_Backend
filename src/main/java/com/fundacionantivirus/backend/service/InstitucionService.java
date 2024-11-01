package com.fundacionantivirus.backend.service;

import com.fundacionantivirus.backend.model.Institucion;
import com.fundacionantivirus.backend.model.Ubicacion;
import com.fundacionantivirus.backend.repository.InstitucionRepository;
import com.fundacionantivirus.backend.repository.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitucionService {

    @Autowired
    private InstitucionRepository repository;

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public List<Institucion> getAll() {
        return repository.findAll();
    }

    public Institucion create(Institucion institucion) {
        return repository.save(institucion);
    }

    public Institucion update(Long id, Institucion institucion) {
        Institucion existing = repository.findById(id).orElseThrow();
        existing.setNombre(institucion.getNombre());
        existing.setDireccion(institucion.getDireccion());

        Ubicacion ubicacion = ubicacionRepository.findById((long) existing.getIdRegion().getId()).orElseThrow();
        institucion.setIdRegion(ubicacion);
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
