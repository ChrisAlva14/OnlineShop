package com.maintenance.esfe.demo.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.maintenance.esfe.demo.Entities.Producto;
import com.maintenance.esfe.demo.Repositories.ProductoRepository;


@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // MOSTRAR PRODUCTOS
    @GetMapping({ "", "/" })
    public String mostrarProductosLista(Model model) {
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "productos/index"; // NOMBRE DE LA CARPETA / NOMBRE DEL ARCHIVO
    }
}