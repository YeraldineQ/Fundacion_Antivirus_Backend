package com.fundacionantivirus.backend.service;

import com.fundacionantivirus.backend.dto.FiltrarOportunidadesDTO;
import com.fundacionantivirus.backend.model.Oportunidad;
import com.fundacionantivirus.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiltroService {


    @Autowired
    private OportunidadRepository repository;

    @Autowired
    private TipoOportunidadRepository tipoOportunidadRepository;

    @Autowired
    private EstadoOportunidadRepository estadoOportunidadRepository;

    @Autowired
    private InformacionOportunidadRepository informacionOportunidadRepository;

    @Autowired
    private CategoriaRepository categoriaOportunidadRepository;

    @Autowired
    private CustomInstitucionesOportunidadesRepositoryImpl customInstitucionesOportunidadesRepository;

    private static List<FiltrarOportunidadesDTO> mapperToDTO(List<Oportunidad> oportunidadesList) {
        return oportunidadesList.stream()
                .flatMap(oportunidad -> oportunidad.getInstitucionOportunidad().stream()
                        .map(institucion -> new FiltrarOportunidadesDTO(
                                oportunidad.getTipoOportunidad().getNombre(),
                                institucion.getIdRegion().getId(), // Accediendo a la región de la institución
                                oportunidad.getCategoriaOportinidad().getId(),
                                institucion.getId(), // ID de la institución
                                institucion.getIdRegion().getRegion(), // Nombre de la región
                                oportunidad.getTipoOportunidad().getNombre(),
                                institucion.getNombre(), // Nombre de la institución
                                oportunidad.getTipoOportunidad().getUrl() // Otros atributos
                        ))
                )
                .collect(Collectors.toList());
    }


    //Filtrar oportunidades.
    public List<FiltrarOportunidadesDTO> filtrador(FiltrarOportunidadesDTO filtrarOportunidadesDTO) {

        List<Oportunidad> OportunidadList = customInstitucionesOportunidadesRepository.filtrarOportunidades(filtrarOportunidadesDTO);

        List<FiltrarOportunidadesDTO> filtrarOportunidadesDTOList = mapperToDTO(OportunidadList);

        return filtrarOportunidadesDTOList;
    }

    //Obtener todas las relaciones institución-oportunidad.
    public List<FiltrarOportunidadesDTO> filtrador() {

        List<Oportunidad> institucionesOportunidadesList = repository.findAll();

        List<FiltrarOportunidadesDTO> filtrarOportunidadesDTOList = mapperToDTO(institucionesOportunidadesList);

        return filtrarOportunidadesDTOList;
    }


}
