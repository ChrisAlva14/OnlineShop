package com.maintenance.esfe.demo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "el nombre es requerido")
    @Column(name = "nombre", length = 100)
    private String nombre;

    @NotBlank(message = "La dirección es requerida")
    @Column(name = "direccion", length = 100)
    private String direccion;

    @NotBlank(message = "El email es requerido")
    @Column(name = "email", length = 50)
    private String email;

    @NotBlank(message = "El telefono es requerido")
    @Column(name = "telefono", length = 50)
    private String telefono;

    //constructor vacio//
    public Cliente(){
      
    }

    public Cliente(int id){
        this.id = id;
    }
    //Contructor lleno//
    public Cliente(String nombre, String direccion,String email,String telefono){
        
        this.nombre=nombre;
        this.direccion=direccion;
        this.email=email;
        this.telefono=telefono;
      
    }

    public Cliente(int id, String nombre, String direccion,String email,String telefono){
        this.id = id;
        this.nombre=nombre;
        this.direccion=direccion;
        this.email=email;
        this.telefono=telefono;
      
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "el nombre es requerido") String getNombre() {
        return nombre;
    }
    public void setNombre(@NotBlank(message = "el nombre es requerido") String nombre) {
        this.nombre = nombre;
    }
    
    public @NotBlank(message="La direccion es requerida")String getDieccion() {
        return direccion;
    }
    public void setDireccion(@NotBlank(message="La direccion es requerida")String direccion) {
        this.direccion = direccion;
    }
    public @NotBlank(message="El email es requerido")String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message="El email es requerido")String email) {
        this.email = email;
    }

    public @NotBlank(message="El telefono es requerido") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotBlank(message="El telefono es requerido") String telefono) {
        this.telefono = telefono;
    }
        
   

    
    

}
