package com.ciberfarma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ciberfarma.model.Registrar;
import com.ciberfarma.repository.IRegistrarRepository;

import java.sql.Date;

@Controller
public class RegistrarController {

    @Autowired
    private IRegistrarRepository repo; 

    @GetMapping("/registrar")
    public String registrar() {
        return "registrar";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(
            @RequestParam("txtNombre") String nom_usua,
            @RequestParam("txtApellido") String ape_usua,
            @RequestParam("txtUsuario") String usr_usua,
            @RequestParam("txtClave") String cla_usua,
            @RequestParam("txtNacimiento") String fna_usua,
            Model model) {

        try {
            Registrar nuevo = new Registrar();
            nuevo.setNom_usua(nom_usua);
            nuevo.setApe_usua(ape_usua);
            nuevo.setCorreo(usr_usua);
            nuevo.setClave(cla_usua);
            nuevo.setFna_usua(Date.valueOf(fna_usua)); 


            repo.save(nuevo);

            model.addAttribute("mensaje", "Usuario registrado correctamente");
            model.addAttribute("cssmensaje", "alert alert-success");
        } catch (Exception e) {
            model.addAttribute("mensaje", "Error al registrar: " + e.getMessage());
            model.addAttribute("cssmensaje", "alert alert-danger");
            
        }
        
        model.addAttribute("nombre", nom_usua);
        model.addAttribute("apellido", ape_usua);

        return "redirect:/principal";
    }
    @GetMapping("/principal")
    public String principal() {
        return "principal";
    }
    
}
