package com.fundacionantivirus.backend.service;

import com.fundacionantivirus.backend.model.Ubicacion;
import com.fundacionantivirus.backend.repository.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository repository;

    public List<Ubicacion> getAll() {
        return repository.findAll();
    }

    public Ubicacion create(Ubicacion ubicacion) {
        return repository.save(ubicacion);
    }

    public Ubicacion update(Long id, Ubicacion ubicacion) {
        Ubicacion existing = repository.findById(id).orElseThrow();
        existing.setDireccion(ubicacion.getDireccion());
        existing.setInstitucion(ubicacion.getInstitucion());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}