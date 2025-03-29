package com.example.TP1SD2.controllers;

import com.example.TP1SD2.entities.Producto;
import com.example.TP1SD2.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/{codigoBarras}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer codigoBarras) {
        Optional<Producto> producto = productoService.buscarPorCodigo(codigoBarras);

        return producto.map(p -> ResponseEntity.ok(p))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}