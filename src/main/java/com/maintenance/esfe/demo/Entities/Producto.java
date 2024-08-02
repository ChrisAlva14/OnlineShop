package com.maintenance.esfe.demo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Producto")
public class Producto {

    // IDENTIFICADOR UNICO DE CADA REGISTRO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "CAMPO REQUERIDO")
    @Column(name = "nombre", length = 100)
    private String nombre;

    @NotBlank(message = "CAMPO REQUERIDO")
    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @NotBlank(message = "CAMPO REQUERIDO")
    @Column(name = "precio")
    private double precio;

    @NotBlank(message = "CAMPO REQUERIDO")
    @Column(name = "categoria", length = 100)
    private String categoria;

    @NotBlank(message = "CAMPO REQUERIDO")
    @Column(name = "stock")
    private int stock;

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // CONSTRUCTORES
    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(int id, String nombre, String descripcion, double precio, String categoria, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }
}