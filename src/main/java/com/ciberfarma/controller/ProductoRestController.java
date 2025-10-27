package com.ciberfarma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ciberfarma.model.Productos;
import com.ciberfarma.repository.IProductoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    @Autowired
    private IProductoRepository repoProd;

    // Obtener todos los productos
    @GetMapping
    public List<Productos> listar() {
        return repoProd.findAll();
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Productos> obtener(@PathVariable String id) {
        return repoProd.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo producto
    @PostMapping
    public ResponseEntity<Productos> crear(@RequestBody Productos producto) {
        // Generar ID manual si es necesario (igual que en tu MVC)
        if (producto.getIdProd() == null || producto.getIdProd().isEmpty()) {
            Productos ultimo = repoProd.findTopByOrderByIdProdDesc();
            String nuevoId = "P0001";
            if (ultimo != null) {
                int num = Integer.parseInt(ultimo.getIdProd().substring(1)) + 1;
                nuevoId = String.format("P%04d", num);
            }
            producto.setIdProd(nuevoId);
        }

        return ResponseEntity.ok(repoProd.save(producto));
    }

    // Actualizar producto
    @PutMapping("/{id}")
    public ResponseEntity<Productos> actualizar(@PathVariable String id, @RequestBody Productos producto) {
        if (!repoProd.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        producto.setIdProd(id);
        return ResponseEntity.ok(repoProd.save(producto));
    }

    // Eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        if (!repoProd.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repoProd.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
