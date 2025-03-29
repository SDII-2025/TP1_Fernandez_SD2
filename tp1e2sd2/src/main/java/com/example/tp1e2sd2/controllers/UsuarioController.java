package com.example.tp1e2sd2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.tp1e2sd2.services.UsuarioService;

@Controller
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String iniciarSesion(@RequestParam String usuario, @RequestParam String contrasena, Model model) {
        if (usuarioService.iniciarSesion(usuario, contrasena).isPresent()) {
            model.addAttribute("mensaje", "Login exitoso");
            return "login";
        } else {
            model.addAttribute("mensaje", "Usuario o contraseña incorrectos");
            return "login";
        }
    }

    @GetMapping("/registrar")
    public String mostrarRegistrar() {
        return "registrar";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@RequestParam String usuario, @RequestParam String contrasena, Model model) {
        String mensaje = usuarioService.registrarUsuario(usuario, contrasena);
        model.addAttribute("mensaje", mensaje);
        return "registrar";
    }

    @GetMapping("/cambiarContrasena")
    public String mostrarCambiarContrasena() {
        return "cambiarContrasena";
    }

    @PostMapping("/cambiarContrasena")
    public String cambiarContrasena(@RequestParam String usuario, @RequestParam String contrasenaNueva, Model model) {
        String mensaje = usuarioService.cambiarContrasena(usuario, contrasenaNueva);
        model.addAttribute("mensaje", mensaje);
        return "cambiarContrasena";
    }
}
