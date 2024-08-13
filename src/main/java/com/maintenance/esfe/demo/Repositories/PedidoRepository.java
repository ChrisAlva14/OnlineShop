package com.maintenance.esfe.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maintenance.esfe.demo.Entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
