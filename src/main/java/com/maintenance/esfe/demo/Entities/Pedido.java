package com.maintenance.esfe.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate fechaPedido;
    private String estadoPedido;  // Los posibles valores son "pendiente", "enviado", "entregado", "cancelado"
    private int clienteId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    // CONSTRUCTORES
    public Pedido(Integer id) {
        this.id = id;
    }

    public Pedido(int id, LocalDate fechaPedido, String estadoPedido, int clienteId) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.estadoPedido = estadoPedido;
        this.clienteId = clienteId;
    }
}
