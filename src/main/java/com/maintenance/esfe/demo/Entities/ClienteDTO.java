package com.maintenance.esfe.demo.Entities;

import jakarta.validation.constraints.NotEmpty;


public class ClienteDTO {
    @NotEmpty(message = "CAMPO REQUERIDO")
    private String nombre;

    private String direccion;
    private String email;

    private String telefono;

    

    // GETTERS AND SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
   

    

