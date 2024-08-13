package com.maintenance.esfe.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.maintenance.esfe.demo.Entities.Cliente;
import com.maintenance.esfe.demo.Entities.ClienteDTO;
import com.maintenance.esfe.demo.Repositories.ClienteRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // MOSTRAR CLIENTES
    @GetMapping({ "", "/" })
    public String mostrarClientesLista(Model model) {
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes/index"; // NOMBRE DE LA CARPETA / NOMBRE DEL ARCHIVO
    }

    // CREAR NUEVO CLIENTE
    @GetMapping("/create")
    public String crearCliente(Model model) {
        ClienteDTO clienteDTO = new ClienteDTO();
        model.addAttribute("clienteDTO", new ClienteDTO());
        return "clientes/createcliente";
    }

    @PostMapping("/create")
    public String crearClienteNuevo(@Valid @ModelAttribute ClienteDTO clienteDTO, BindingResult BindingResult) {

        // VALIDA SI NO HAY ALGUN ERROR
        if (BindingResult.hasErrors()) {
            return "clientes/createCliente";
        }

        // GUARDAR EN EL REPOSITORIO
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefono(clienteDTO.getTelefono());

        clienteRepository.save(cliente);

        // RETORNA A LA VISTA INDEX DE CLIENTES
        return "redirect:/clientes";
    }

    // MODIFICAR UN CLIENTE
    @GetMapping("/edit")
    public String modificarCliente(Model model, @RequestParam int id) {

        try {
            Cliente cliente = clienteRepository.findById(id).get();
            model.addAttribute("cliente", cliente);

            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setNombre(cliente.getNombre());
            clienteDTO.setDireccion(cliente.getDireccion());
            clienteDTO.setEmail(cliente.getEmail());
            clienteDTO.setTelefono(cliente.getTelefono());

            model.addAttribute("clienteDTO", clienteDTO);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/clientes";
        }

        return "clientes/editClientes";
    }

    @PostMapping("/edit")
    public String modificarClienteNuevo(Model model, @RequestParam int id, @Valid @ModelAttribute ClienteDTO clienteDTO,
            BindingResult bindingResult) {

        try {

            Cliente cliente = clienteRepository.findById(id).get();
            model.addAttribute("cliente", cliente);

            // VALIDA SI NO HAY ALGUN ERROR
            if (bindingResult.hasErrors()) {
                return "clientes/editClientes";
            }
        } catch (Exception e) {

        }

        return "redirect:/clientes";

    }

    // ELIMINAR UN CLIENTE
    @GetMapping("/delete")
    public String eliminarCliente(@RequestParam int id) {

        try {
            Cliente cliente = clienteRepository.findById(id).get();

            // ELIMINAR CLIENTE DE LA DATABASE
            clienteRepository.delete(cliente);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/clientes";
        }
        return "redirect:/clientes";
    }
}