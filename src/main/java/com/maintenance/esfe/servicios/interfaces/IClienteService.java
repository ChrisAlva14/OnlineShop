 package com.maintenance.esfe.Servicios.interfaces;

import com.maintenance.esfe.demo.Entities.Cliente;
import com.maintenance.esfe.demo.Entities.ClienteDTO;


import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<Cliente> obtenerTodosLosClientes();

    Optional<Cliente> obtenerClientePorId(Integer id);

    Cliente crearCliente(ClienteDTO clienteDTO);

    Cliente actualizarCliente(Integer id, ClienteDTO clienteDTO);

    void eliminarCliente(Integer id);
     
}
