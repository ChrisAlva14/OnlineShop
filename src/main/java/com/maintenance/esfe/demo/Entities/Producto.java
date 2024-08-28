package com.maintenance.esfe.demo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Producto")
public class Producto {

    // IDENTIFICADOR UNICO DE CADA REGISTRO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "CAMPO REQUERIDO")
    @Column(name = "nombre", length = 100)
    private String nombre;

    @NotBlank(message = "CAMPO REQUERIDO")
    @Size(min = 10, message = "LA DESCRIPCION DEBE CONTENER AL MENOS 10 CARACTERES")
    @Size(max = 2000, message = "LA DESCRIPCION NO PUEDE EXCEDER LOS 2,000 CARACTERES")
    private String descripcion;

    @Column(name = "precio")
    private double precio;

    @NotBlank(message = "CAMPO REQUERIDO")
    @Column(name = "categoria", length = 100)
    private String categoria;

    @Column(name = "stock")
    private Integer stock;

    @NotBlank(message = "La imagen no puede estar vacía")
    @Column(name = "imagen")
    private String imagenFile;

    // GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImagenFile() {
        return imagenFile;
    }

    public void setImagenFile(String imagenFile) {
        this.imagenFile = imagenFile;
    }

    // CONSTRUCTORES

    public Producto() {
    }

    public Producto(Integer id, @NotBlank(message = "CAMPO REQUERIDO") String nombre,
            @NotBlank(message = "CAMPO REQUERIDO") String descripcion,
            @NotBlank(message = "El precio no puede estar vacío") Double precio,
            @NotBlank(message = "CAMPO REQUERIDO") String categoria,
            @NotBlank(message = "El precio no puede estar vacío") Integer stock,
            @NotBlank(message = "La imagen no puede estar vacía") String imagenFile) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
        this.imagenFile = imagenFile;
    }
}