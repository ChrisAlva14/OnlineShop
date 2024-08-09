package com.maintenance.esfe.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.maintenance.esfe.demo.Entities.Cliente;
import com.maintenance.esfe.demo.Repositories.ClienteRepository;


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
}