package com.example.tp1e2sd2.controllers;

import com.example.tp1e2sd2.services.DolarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dollar")
@Tag(name = "Dólar", description = "Consulta de cotizaciones del dólar")
public class DolarController {

    @Autowired
    private DolarService dolarService;

    @Operation(
            summary = "Obtener cotizaciones del dólar",
            description = "Permite obtener el valor del dólar. Se puede especificar el tipo usando el parámetro 'ask'. Si no se indica, se usa 'ALL' por defecto."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cotizaciones obtenidas exitosamente"),
            @ApiResponse(responseCode = "400", description = "Parámetro inválido")
    })
    @GetMapping("/values")
    public Object obtenerValor(
            @Parameter(
                    description = "Tipo de cotización a consultar. Ej: BLUE, OFICIAL, MEP, CCL, etc. Por defecto: ALL.",
                    example = "BLUE"
            )
            @RequestParam(defaultValue = "ALL") String ask
    ) {
        return dolarService.obtenerValores(ask);
    }
}
