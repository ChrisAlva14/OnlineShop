package com.maintenance.esfe.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maintenance.esfe.demo.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
   


    // Método para encontrar productos que contengan una palabra clave en el nombre
    List<Producto> findByNombreContaining(String nombre);

    // Método para encontrar productos por categoría
    List<Producto> findByCategoria(String categoria);

    // Método para encontrar productos con un stock menor que el especificado
    List<Producto> findByStockLessThan(Integer stock);

    // Método para encontrar productos con un precio entre un rango
    List<Producto> findByPrecioBetween(Double precioMin, Double precioMax);

    // Método para encontrar productos con una descripción específica (exacta)
    List<Producto> findByDescripcion(String descripcion);

    // Método para obtener todos los productos ordenados por precio ascendente
    List<Producto> findAllByOrderByPrecioAsc();

    // Método para obtener todos los productos ordenados por precio descendente
    List<Producto> findAllByOrderByPrecioDesc();

}