package com.maintenance.esfe.demo.Entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;

public class PedidoDTO {

    @NotNull(message = "La fecha del pedido es requerida")
    private Date fechaPedido;

    @NotBlank(message = "El estado del pedido es requerido")
    private String estadoPedido;

    @NotNull(message = "El ID del cliente es requerido")
    private Integer clienteId;

    // Getters y Setters
    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
}
