package com.maintenance.esfe.demo.Repositories;

import com.maintenance.esfe.demo.Entities.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
