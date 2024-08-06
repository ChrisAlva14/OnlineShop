package com.maintenance.esfe.demo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

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
    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @NotBlank(message = "El precio no puede estar vacío")
    @Column(name = "precio")
    private Double precio;

    @NotBlank(message = "CAMPO REQUERIDO")
    @Column(name = "categoria", length = 100)
    private String categoria;

    @NotBlank(message = "El precio no puede estar vacío")
    @Column(name = "stock")
    private Integer stock;

    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    // CONSTRUCTORES
    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, String nombre, String descripcion, Double precio, String categoria, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

}