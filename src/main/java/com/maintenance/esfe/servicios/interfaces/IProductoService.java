package com.maintenance.esfe.Servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.maintenance.esfe.demo.Entities.Producto;
import com.maintenance.esfe.demo.Entities.ProductoDTO;

public interface IProductoService {

    List<Producto> getAllProductos();

    Optional<Producto> getProductoById(Integer id);

    Producto createProducto(ProductoDTO productoDTO);

    Producto updateProducto(Integer id, ProductoDTO productoDTO);

    void deleteProducto(Integer id);
}
