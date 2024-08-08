package com.maintenance.esfe.demo.Entities;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ProductoDTO {
    @NotEmpty(message = "CAMPO REQUERIDO")
    private String nombre;

    @Size(min = 10, message = "LA DESCRIPCION DEBE CONTENER AL MENOS 10 CARACTERES")
    @Size(max = 2000, message = "LA DESCRIPCION NO PUEDE EXCEDER LOS 2,000 CARACTERES")
    private String descripcion;
    @Min(0)
    private Double precio;

    @Min(0)
    private Integer stock;

    @NotEmpty(message = "CAMPO REQUERIDO")
    private String categoria;

    private MultipartFile imagenFile;

    // GETTERS AND SETTERS

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

    public MultipartFile getImagenFile() {
        return imagenFile;
    }

    public void setImagenFile(MultipartFile imagenFile) {
        this.imagenFile = imagenFile;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
