package com.maintenance.esfe.demo.Repositories;

import com.maintenance.esfe.demo.Entities.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
// Buscar por nombre 
    List<Cliente> findByNombreContaining(String nombre);
    // Buscar por Direccion
    List<Cliente> findByDireccion(String direccion);
    // Buscar por Email
    Cliente findByEmail(String email);
    //Buscar por teléfono
    List<Cliente> findByTelefono(String telefono);
   



}

