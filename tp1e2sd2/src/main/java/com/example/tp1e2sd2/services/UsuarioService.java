package com.example.tp1e2sd2.services;

import com.example.tp1e2sd2.entities.Usuario;
import com.example.tp1e2sd2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> iniciarSesion(String nombre, String contrasena) {
        return usuarioRepository.findByNombre(nombre).filter( usuario -> usuario.getContrasena().equals(contrasena));
    }

    public String registrarUsuario(String nombre, String contrasena) {
        if (usuarioRepository.existsByNombre(nombre)) {
            return "Usuario ya existe";
        }
        usuarioRepository.save(new Usuario(nombre, contrasena));
        return "Usuario registrado";
    }

    public String cambiarContrasena(String nombre, String nuevaContrasena) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByNombre(nombre);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setContrasena(nuevaContrasena);
            usuarioRepository.save(usuario);
            return "Contraseña cambiada";
        }
        return "Usuario no encontrado";
    }
}
