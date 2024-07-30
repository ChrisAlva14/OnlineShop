package com.maintenance.esfe.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.maintenance.esfe.demo.Repositories.ProductoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.maintenance.esfe.demo.Entities.Producto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/productos")

public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // CREAR UN PRODUCTO
    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Integer Id) {
        return productoRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("NO SE ENCONTRÓ EL PRODUCTO CON EL ID " + Id));
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Integer Id, @RequestBody Producto detallesProducto) {
        Producto producto = productoRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("NO SE ENCONTRÓ EL PRODUCTO CON EL ID " + Id));

        producto.setNombre(detallesProducto.getNombre());
        producto.setDescripcion(detallesProducto.getDescripcion());
        producto.setPrecio(detallesProducto.getPrecio());
        producto.setCategoria(detallesProducto.getCategoria());
        producto.setStock(detallesProducto.getStock());

        return productoRepository.save(producto);

    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Integer Id) {
        Producto producto = productoRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("NO SE ENCONTRÓ EL PRODUCTO CON EL ID " + Id));

        productoRepository.delete(producto);

        return "EL PRODUCTO CON EL ID: " + Id + " FUE ELIMINADO CORRECTAMENTE";
    }
}