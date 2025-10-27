package com.ciberfarma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ciberfarma.model.Registrar;
import com.ciberfarma.repository.IRegistrarRepository;


@RestController
@RequestMapping("/api/registrar")
public class RegistrarRestController {

    @Autowired
    private IRegistrarRepository repo;

    @PostMapping
    public ResponseEntity<?> registrarUsuario(@RequestBody Registrar nuevo) {
        try {

            Registrar guardado = repo.save(nuevo);
            guardado.setClave(null); 

            return ResponseEntity.ok(guardado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar usuario: " + e.getMessage());
        }
    }
}
