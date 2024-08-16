package com.maintenance.esfe.demo.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maintenance.esfe.demo.Entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    // Buscar pedidos por estado
    List<Pedido> findByEstadoPedido(String estadoPedido);

    // Buscar pedidos por fecha de pedido
    List<Pedido> findByFechaPedido(LocalDate fechaPedido);

    // Buscar pedidos por cliente
    List<Pedido> findByClienteId(Integer clienteId);

    // Buscar pedidos por estado y cliente
    List<Pedido> findByEstadoPedidoAndClienteId(String estadoPedido, Integer clienteId);

    // Buscar pedidos dentro de un rango de fechas
    List<Pedido> findByFechaPedidoBetween(LocalDate startDate, LocalDate endDate);

    // Buscar pedidos con un estado específico ordenados por fecha
    List<Pedido> findByEstadoPedidoOrderByFechaPedidoAsc(String estadoPedido);

    // Contar pedidos por estado
    Long countByEstadoPedido(String estadoPedido);

    // Eliminar pedidos por estado
    void deleteByEstadoPedido(String estadoPedido);

    // Verificar existencia de pedidos por cliente
    boolean existsByClienteId(Integer clienteId);
    
}
