package com.fundacionantivirus.backend.controller;

import com.fundacionantivirus.backend.dto.FiltrarOportunidadesDTO;
import com.fundacionantivirus.backend.service.FiltroService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/filtro")
public class Filtro {

    @Autowired
    private FiltroService filtroService;

    //Filtrar oportunidades e instituciones
    @Operation(summary = "Este Post filtra todas las Oportunidades de la tabla 'instituciones_oportunidades'.", description = "Este método necesita parámetros. Luego hay que darle al botón 'Execute'.")
    @PostMapping
    public List<FiltrarOportunidadesDTO> filtrarOporIns(@RequestBody FiltrarOportunidadesDTO filtrarOportunidadesDTO) {
        return filtroService.filtrador(filtrarOportunidadesDTO);
    }

    // Obtener todas las institucionesOportunidades.
    @Operation(summary = "Este Get muestra todas las institucionesOportunidades de la tabla 'instituciones_oportunidades'.", description = "Este método no necesita de ningún parámetro. Solo hay que darle al botón 'Execute'.")
    @GetMapping
    public List<FiltrarOportunidadesDTO> listarOportunidad() {
        return filtroService.filtrador();
    }
}
