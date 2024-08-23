package com.maintenance.esfe.Servicios.Implementaciones;

import com.maintenance.esfe.Servicios.Interfaces.IPedidoService;
import com.maintenance.esfe.demo.Entities.Pedido;
import com.maintenance.esfe.demo.Entities.PedidoDTO;
import com.maintenance.esfe.demo.Repositories.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> obtenerPedidoPorId(Integer id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido crearPedido(PedidoDTO pedidoDTO) {
       Pedido pedido = new Pedido();
        pedido.setFechaPedido(pedidoDTO.getFechaPedido());
        pedido.setEstadoPedido(pedidoDTO.getEstadoPedido());
        pedido.setClienteId(pedidoDTO.getClienteId());
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido actualizarPedido(Integer id, PedidoDTO pedidoDTO) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            pedido.setFechaPedido(pedidoDTO.getFechaPedido());
            pedido.setEstadoPedido(pedidoDTO.getEstadoPedido());
            pedido.setClienteId(pedidoDTO.getClienteId());
            return pedidoRepository.save(pedido);
        } else {
            // Puedes lanzar una excepción personalizada si el pedido no existe
            throw new RuntimeException("Pedido no encontrado");
        }
    }

    @Override
    public void eliminarPedido(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
