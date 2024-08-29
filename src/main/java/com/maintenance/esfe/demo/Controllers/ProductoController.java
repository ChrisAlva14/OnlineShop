package com.maintenance.esfe.demo.Controllers;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.maintenance.esfe.demo.Entities.Producto;
import com.maintenance.esfe.demo.Entities.ProductoDTO;
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

    // MOSTRAR DETALLE DE UN PRODUCTO
    @GetMapping("/detalleProducto")
    public String DetalleProducto(Model model, @RequestParam int id) {

        ProductoDTO productoDTO = new ProductoDTO();
        try {
            Producto producto = productoRepository.findById(id).get();
            model.addAttribute("producto", producto);

            productoDTO.setNombre(producto.getNombre());
            productoDTO.setDescripcion(producto.getDescripcion());
            productoDTO.setPrecio(producto.getPrecio());
            productoDTO.setCategoria(producto.getCategoria());
            productoDTO.setStock(producto.getStock());

            model.addAttribute("productoDTO", productoDTO);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/productos";
        }

        return "productos/detalleProducto";
    }

}
