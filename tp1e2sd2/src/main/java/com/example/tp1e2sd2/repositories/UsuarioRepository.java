package com.example.tp1e2sd2.repositories;

import com.example.tp1e2sd2.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
