package com.maintenance.esfe.demo.Entities;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class ClienteDTO {
    @NotEmpty(message = "CAMPO REQUERIDO")
    private String nombre;

    @Size(min = 10, message = "LA DIRECCION DEBE CONTENER AL MENOS 50 CARACTERES")
    @Size(max = 2000, message = "LA DIRECCION NO PUEDE EXCEDER LOS 2,000 CARACTERES")
    private String direccion;
    @Min(0)
    private String email;

    @Min(0)
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
   

    

