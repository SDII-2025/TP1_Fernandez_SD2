package com.example.TP1SD2.services;

import com.example.TP1SD2.entities.Producto;
import com.example.TP1SD2.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Optional<Producto> buscarPorCodigo(int codigoBarras) {
        return productoRepository.findByCodigoBarras(codigoBarras);
    }
}