package com.ciberfarma.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ciberfarma.Lp2Tema04Application;
import com.ciberfarma.model.Productos;
import com.ciberfarma.repository.ICategoriaRepository;
import com.ciberfarma.repository.IProductoRepository;
import com.ciberfarma.repository.IProveedorRepository;


@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Lp2Tema04Application lp2Tema04Application;

    @Autowired
    private ICategoriaRepository repoCat;

    @Autowired
    private IProductoRepository repoProd;

    @Autowired
    private IProveedorRepository repoProv;

    ProductoController(Lp2Tema04Application lp2Tema04Application) {
        this.lp2Tema04Application = lp2Tema04Application;
    }

    // abrir la página crud
    @GetMapping("/cargar")
    public String cargarPag(Model model) {
        model.addAttribute("lstCategorias", repoCat.findAll());
        model.addAttribute("lstProveedor", repoProv.findAll());
        model.addAttribute("producto", new Productos());
        return "crudproductos";
    }

    // registrar producto nuevo
    @PostMapping("/grabar")
    public String grabar(@ModelAttribute Productos producto, Model model) {
        try {

            if (producto.getIdProd() == null || producto.getIdProd().isEmpty()) {
                Productos ultimo = repoProd.findTopByOrderByIdProdDesc();
                String nuevoId = "P0001";

                if (ultimo != null) {
                    int num = Integer.parseInt(ultimo.getIdProd().substring(1)) + 1;
                    nuevoId = String.format("P%04d", num);
                }

                producto.setIdProd(nuevoId);
            }

            repoProd.save(producto);
            model.addAttribute("mensaje", "Registro OK");
            model.addAttribute("cssmensaje", "alert alert-success");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("mensaje", "Error al registrar: " + e.getMessage());
            model.addAttribute("cssmensaje", "alert alert-danger");
        }

      
        return "redirect:/productos/listar";
    }


    // listar productos
    @GetMapping("/listar")
    public String listarProductos(Model model) {
        model.addAttribute("lstProductos", repoProd.findAll());
        model.addAttribute("producto", new Productos());
        model.addAttribute("lstProveedor", repoProv.findAll());
        model.addAttribute("lstCategoria", repoCat.findAll());
        return "crudproductos";
    }

    // editar producto
    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable("id") String id, Model model) {
        Productos prod = repoProd.findById(id).orElse(new Productos());
        model.addAttribute("producto", prod); // carga los datos del producto
        model.addAttribute("lstCategorias", repoCat.findAll());
        model.addAttribute("lstProveedor", repoProv.findAll());
        model.addAttribute("lstProductos", repoProd.findAll());
        return "crudproductos";
    }
    
    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") String id, Model model) {
        Productos producto = repoProd.findById(id).orElse(null);

        if (producto == null) {
            model.addAttribute("mensaje", "Producto no encontrado.");
            model.addAttribute("cssmensaje", "alert alert-danger");
            model.addAttribute("producto", new Productos());
        } else {
            model.addAttribute("producto", producto);
        }

        model.addAttribute("lstProductos", repoProd.findAll());
        model.addAttribute("lstCategorias", repoCat.findAll());
        model.addAttribute("lstProveedor", repoProv.findAll());

        return "crudproductos";
    }


    // eliminar producto
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") String id, Model model) {
        try {
            repoProd.deleteById(id);
            model.addAttribute("mensaje", "Producto eliminado correctamente.");
            model.addAttribute("cssmensaje", "alert alert-success");
        } catch (Exception e) {
            model.addAttribute("mensaje", "Error al eliminar: " + e.getMessage());
            model.addAttribute("cssmensaje", "alert alert-danger");
        }

        model.addAttribute("lstProductos", repoProd.findAll());
        model.addAttribute("lstCategorias", repoCat.findAll());
        model.addAttribute("lstProveedor", repoProv.findAll());
        model.addAttribute("producto", new Productos());

        return "crudproductos";
    }
}
