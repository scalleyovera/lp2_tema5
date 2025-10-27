package com.ciberfarma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ciberfarma.model.Usuario;
import com.ciberfarma.repository.IUsuarioRepository;

@RestController
@RequestMapping("/api/login")
public class LoginRestController {

    @Autowired
    private IUsuarioRepository repoUsu;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Usuario loginRequest) {
        // Buscar usuario por correo y clave
        Usuario usuario = repoUsu.findByCorreoAndClave(loginRequest.getCorreo(), loginRequest.getClave());

        if (usuario != null) {          
            usuario.setClave(null);

            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }
    }
}
