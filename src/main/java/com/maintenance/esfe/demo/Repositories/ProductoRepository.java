package com.maintenance.esfe.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maintenance.esfe.demo.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}