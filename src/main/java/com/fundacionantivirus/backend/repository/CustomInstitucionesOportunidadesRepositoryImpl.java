package com.fundacionantivirus.backend.repository;

import com.fundacionantivirus.backend.dto.FiltrarOportunidadesDTO;
import com.fundacionantivirus.backend.model.Categoria;
import com.fundacionantivirus.backend.model.Institucion;
import com.fundacionantivirus.backend.model.Oportunidad;
import com.fundacionantivirus.backend.model.TipoOportunidad;
import com.fundacionantivirus.backend.model.Ubicacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomInstitucionesOportunidadesRepositoryImpl implements CustomInstitucionesOportunidadesRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Oportunidad> filtrarOportunidades(FiltrarOportunidadesDTO filtrarOportunidadesDTO) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Oportunidad> query = cb.createQuery(Oportunidad.class);
        Root<Oportunidad> root = query.from(Oportunidad.class);

        List<Predicate> predicates = new ArrayList<>();

        // Join con Institucion
        Join<Oportunidad, Institucion> institucionJoin = root.join("institucion", JoinType.INNER);
        
        // Join con TipoOportunidad
        Join<Oportunidad, TipoOportunidad> tipoOportunidadJoin = root.join("tipoOportunidad", JoinType.INNER);
        
        // Join con Categoria
        Join<Oportunidad, Categoria> categoriaJoin = root.join("categoria", JoinType.LEFT);

        // Filtro por nombre
        if (filtrarOportunidadesDTO.getNombre() != null && !filtrarOportunidadesDTO.getNombre().isEmpty()) {
            predicates.add(cb.like(cb.lower(root.get("nombre")), 
                "%" + filtrarOportunidadesDTO.getNombre().toLowerCase() + "%"));
        }

        // Filtro por región
        if (filtrarOportunidadesDTO.getIdRegion() != null) {
            Join<Institucion, Ubicacion> ubicacionJoin = institucionJoin.join("ubicacion", JoinType.INNER);
            predicates.add(cb.equal(ubicacionJoin.get("region").get("id"), 
                filtrarOportunidadesDTO.getIdRegion()));
        }

        // Filtro por institución
        if (filtrarOportunidadesDTO.getIdInstitucion() != null) {
            predicates.add(cb.equal(institucionJoin.get("id"), 
                filtrarOportunidadesDTO.getIdInstitucion()));
        }

        // Filtro por categoría
        if (filtrarOportunidadesDTO.getIdCategoria() != null) {
            predicates.add(cb.equal(categoriaJoin.get("id"), 
                filtrarOportunidadesDTO.getIdCategoria()));
        }

        if (!predicates.isEmpty()) {
            query.where(cb.and(predicates.toArray(new Predicate[0])));
        }

        // Ordenar por fecha de creación descendente
        query.orderBy(cb.desc(root.get("fechaCreacion")));

        TypedQuery<Oportunidad> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
