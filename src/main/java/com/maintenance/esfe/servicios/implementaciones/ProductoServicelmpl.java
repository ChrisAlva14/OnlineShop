package com.maintenance.esfe.Servicios.Implementaciones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.maintenance.esfe.Servicios.Interfaces.IProductoService;
import com.maintenance.esfe.demo.Entities.Producto;
import com.maintenance.esfe.demo.Entities.ProductoDTO;
import com.maintenance.esfe.demo.Repositories.ProductoRepository;

@Service
public class ProductoServicelmpl implements IProductoService {

    private static String UPLOAD_DIRECTORY = "src/main/resources/static/images/";

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> getProductoById(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto createProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setCategoria(productoDTO.getCategoria());
        producto.setStock(productoDTO.getStock());

        MultipartFile imagenFile = productoDTO.getImagenFile();
        if (imagenFile != null && !imagenFile.isEmpty()) {
            try {
                byte[] bytes = imagenFile.getBytes();
                Path path = Paths.get(UPLOAD_DIRECTORY + imagenFile.getOriginalFilename());
                Files.write(path, bytes);
                producto.setImagenFile("/images/" + imagenFile.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Integer id, ProductoDTO productoDTO) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            producto.setNombre(productoDTO.getNombre());
            producto.setDescripcion(productoDTO.getDescripcion());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setCategoria(productoDTO.getCategoria());
            producto.setStock(productoDTO.getStock());

            MultipartFile imagenFile = productoDTO.getImagenFile();
            if (imagenFile != null && !imagenFile.isEmpty()) {
                try {
                    // Eliminar la imagen anterior si existe
                    if (producto.getImagenFile() != null) {
                        Path previousImagePath = Paths.get(UPLOAD_DIRECTORY + producto.getImagenFile().substring(8));
                        Files.deleteIfExists(previousImagePath);
                    }

                    byte[] bytes = imagenFile.getBytes();
                    Path path = Paths.get(UPLOAD_DIRECTORY + imagenFile.getOriginalFilename());
                    Files.write(path, bytes);
                    producto.setImagenFile("/images/" + imagenFile.getOriginalFilename());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return productoRepository.save(producto);
        } else {
            throw new RuntimeException("Producto no encontrado con id: " + id);
        }

    }

    @Override
    public void deleteProducto(Integer id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();

            // Eliminar la imagen asociada si existe
            if (producto.getImagenFile() != null) {
                try {
                    Path imagePath = Paths.get(UPLOAD_DIRECTORY + producto.getImagenFile().substring(8));
                    Files.deleteIfExists(imagePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            productoRepository.delete(producto);
        } else {
            throw new RuntimeException("Producto no encontrado con id: " + id);
        }
    }

    public static ProductoDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}