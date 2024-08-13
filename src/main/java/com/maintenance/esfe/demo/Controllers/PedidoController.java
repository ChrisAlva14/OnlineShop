package com.maintenance.esfe.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import com.maintenance.esfe.demo.Entities.Pedido;
import com.maintenance.esfe.demo.Entities.PedidoDTO;
import com.maintenance.esfe.demo.Repositories.PedidoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    // MOSTRAR PEDIDOS
    @GetMapping({ "", "/" })
    public String mostrarPedidosLista(Model model) {
        List<Pedido> pedidos = pedidoRepository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "pedidos/index"; // NOMBRE DE LA CARPETA / NOMBRE DEL ARCHIVO
    }

    // CREAR NUEVO PEDIDO
    @GetMapping("/create")
    public String crearPedido(Model model) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        model.addAttribute("pedidoDTO", new PedidoDTO());
        return "pedidos/createPedido";
    }

    @PostMapping("/create")
    public String crearPedidoNuevo(@Valid @ModelAttribute PedidoDTO pedidoDTO, BindingResult bindingResult) {
        // VALIDA SI NO HAY ALGUN ERROR
        if (bindingResult.hasErrors()) {
            return "pedidos/createPedido";
        }

        Pedido pedido = new Pedido();
        pedido.setFechaPedido(new java.sql.Date(System.currentTimeMillis())); // Establece la fecha actual
        pedido.setEstadoPedido("pendiente"); // Estado inicial por defecto
        pedido.setClienteId(pedidoDTO.getClienteId());

        // GUARDAR EN EL REPOSITORIO
        pedidoRepository.save(pedido);

        // RETORNA A LA VISTA INDEX DE PEDIDOS
        return "redirect:/pedidos";
    }

    // MODIFICAR UN PEDIDO
    @GetMapping("/edit")
    public String modificarPedido(Model model, @RequestParam int id) {

        try {
            Pedido pedido = pedidoRepository.findById(id).get();
            model.addAttribute("pedido", pedido);

            PedidoDTO pedidoDTO = new PedidoDTO();
            pedidoDTO.setFechaPedido(pedido.getFechaPedido());
            pedidoDTO.setEstadoPedido(pedido.getEstadoPedido());
            pedidoDTO.setClienteId(pedido.getClienteId());

            model.addAttribute("pedidoDTO", pedidoDTO);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/pedidos";
        }

        return "pedidos/editarPedido";
    }

    @PostMapping("/edit")
    public String modificarPedidoNuevo(Model model, @RequestParam int id,
            @Valid @ModelAttribute PedidoDTO pedidoDTO,
            BindingResult bindingResult) {

        try {

            Pedido pedido = pedidoRepository.findById(id).get();
            model.addAttribute("pedidos", pedido);

            // VALIDA SI NO HAY ALGUN ERROR
            if (bindingResult.hasErrors()) {
                return "pedidos/editarPedido";
            }

            pedido.setFechaPedido(pedidoDTO.getFechaPedido());
            pedido.setEstadoPedido(pedidoDTO.getEstadoPedido());
            pedido.setClienteId(pedidoDTO.getClienteId());

            pedidoRepository.save(pedido);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/pedidos";
        }

        return "redirect:/pedidos";
    }

    // ELIMINAR UN PEDIDO
    @GetMapping("/delete")
    public String eliminarPedido(@RequestParam int id) {

        try {
            Pedido pedido = pedidoRepository.findById(id).get();

            // ELIMINAR PEDIDO DE LA BASE DE DATOS
            pedidoRepository.delete(pedido);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/pedidos";
        }
        return "redirect:/pedidos";
    }
}
