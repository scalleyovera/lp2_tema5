package com.ciberfarma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ciberfarma.model.Proveedor;
import com.ciberfarma.repository.IProveedorRepository;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorRestController {

    @Autowired
    private IProveedorRepository repoProv;

    @GetMapping
    public List<Proveedor> listar() {
        return repoProv.findAll();
    }
}
