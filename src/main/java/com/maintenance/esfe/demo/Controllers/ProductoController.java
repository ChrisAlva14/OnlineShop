package com.maintenance.esfe.demo.Controllers;

import java.io.InputStream;
import java.nio.file.*;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.maintenance.esfe.demo.Entities.Producto;
import com.maintenance.esfe.demo.Entities.ProductoDTO;
import com.maintenance.esfe.demo.Repositories.ProductoRepository;

import jakarta.validation.Valid;

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

    // CREAR NUEVO PRODUCTO
    @GetMapping("/create")
    public String crearProducto(Model model) {
        ProductoDTO productoDTO = new ProductoDTO();
        model.addAttribute("productoDTO", new ProductoDTO());
        return "productos/createProducto";
    }

    @PostMapping("/create")
    public String crearProductoNuevo(@Valid @ModelAttribute ProductoDTO productoDTO, BindingResult BindingResult) {
        // VALIDA QUE SE HAYA SUBIDO LA IMAGEN
        if (productoDTO.getImagenFile().isEmpty()) {
            BindingResult.addError(new FieldError("productoDTO", "imagenFile", "LA IMAGEN ES REQUERIDA"));
        }

        // VALIDA SI NO HAY ALGUN ERROR
        if (BindingResult.hasErrors()) {
            return "productos/createProducto";
        }

        // GUARDAR LA IMAGEN
        MultipartFile imagen = productoDTO.getImagenFile();
        Date creado = new Date(0);
        String nombreArchivoAlmacenado = creado.getTime() + "_" + imagen.getOriginalFilename();

        try {
            String uploadDir = "public/images/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {

                Files.createDirectories(uploadPath);
            }

            try (InputStream inputStream = imagen.getInputStream()) {
                Files.copy(inputStream, Paths.get(uploadDir + nombreArchivoAlmacenado),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setCategoria(productoDTO.getCategoria());
        producto.setStock(productoDTO.getStock());
        producto.setImagenFile(nombreArchivoAlmacenado);

        // GUARDAR EN EL REPOSITORIO
        productoRepository.save(producto);

        // RETORNA A LA VISTA INDEX DE PRODUCTOS
        return "redirect:/productos";
    }

    // MODIFICAR UN PRODUCTO
    @GetMapping("/edit")
    public String modificarProducto(Model model, @RequestParam int id) {

        try {
            Producto producto = productoRepository.findById(id).get();
            model.addAttribute("producto", producto);

            ProductoDTO productoDTO = new ProductoDTO();
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

        return "productos/editProductos";
    }

    @PostMapping("/edit")
    public String modificarProductoNuevo(Model model, @RequestParam int id,
            @Valid @ModelAttribute ProductoDTO productoDTO,
            BindingResult BindingResult) {

        try {

            Producto producto = productoRepository.findById(id).get();
            model.addAttribute("producto", producto);

            // VALIDA SI NO HAY ALGUN ERROR
            if (BindingResult.hasErrors()) {
                return "productos/editProductos";
            }

            // ACTUALIZAR IMAGEN

            if (!productoDTO.getImagenFile().isEmpty()) {
                // ELIMINAR LA IMG VIEJA
                String uploadDir = "public/images/";
                Path oldImagePath = Paths.get(uploadDir + producto.getImagenFile());
                try {
                    Files.delete(oldImagePath);
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex.getMessage());
                }

                // GUARDAR LA NUEVA IMG
                MultipartFile image = productoDTO.getImagenFile();
                Date createdAt = new Date(0);
                String storageFileName = createdAt.getTime() + " " + image.getOriginalFilename();
                try (InputStream inputStream = image.getInputStream()) {
                    Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
                            StandardCopyOption.REPLACE_EXISTING);
                }

                producto.setImagenFile(storageFileName);
            }

            producto.setNombre(productoDTO.getNombre());
            producto.setDescripcion(productoDTO.getDescripcion());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setCategoria(productoDTO.getCategoria());
            producto.setStock(productoDTO.getStock());

            productoRepository.save(producto);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/productos";
        }

        return "redirect:/productos";
    }

    // ELIMINAR UN PRODUCTO
    @GetMapping("/delete")
    public String eliminarProducto(@RequestParam int id) {

        try {
            Producto producto = productoRepository.findById(id).get();

            Path imagePath = Paths.get("public/images/" + producto.getImagenFile());

            try {
                Files.delete(imagePath);
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }

            //ELIMINAR PRODUCTO DE LA DATABASE
            productoRepository.delete(producto);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/productos";
        }
        return "redirect:/productos";
    }
}