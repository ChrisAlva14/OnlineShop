package com.maintenance.esfe.Servicios.implementaciones;

import com.maintenance.esfe.Servicios.interfaces.IClienteService;
import com.maintenance.esfe.demo.Entities.Cliente;
import com.maintenance.esfe.demo.Entities.ClienteDTO;
import com.maintenance.esfe.demo.Repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
       return clienteRepository.findAll();  
  }

    @Override
    public Optional<Cliente> obtenerClientePorId(Integer id) {
        
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente crearCliente(ClienteDTO clienteDTO) {
        
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefono(clienteDTO.getTelefono());
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Integer id, ClienteDTO clienteDTO) {

        
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefono(clienteDTO.getTelefono());
       return clienteRepository.save(cliente);
    } 

    @Override
    public void eliminarCliente(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'eliminar Cliente'");
    }

    
}
    

