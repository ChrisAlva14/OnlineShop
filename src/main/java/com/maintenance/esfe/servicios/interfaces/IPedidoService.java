package com.maintenance.esfe.Servicios.Interfaces;

import com.maintenance.esfe.demo.Entities.Pedido;
import com.maintenance.esfe.demo.Entities.PedidoDTO;

import java.util.List;
import java.util.Optional;

public interface IPedidoService {

    List<Pedido> obtenerTodosLosPedidos();

    Optional<Pedido> obtenerPedidoPorId(Integer id);

    Pedido crearPedido(PedidoDTO pedidoDTO);

    Pedido actualizarPedido(Integer id, PedidoDTO pedidoDTO);

    void eliminarPedido(Integer id);
}