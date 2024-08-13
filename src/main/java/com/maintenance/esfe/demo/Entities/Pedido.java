package com.maintenance.esfe.demo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "Pedido")
public class Pedido {

    // IDENTIFICADOR ÚNICO DE CADA REGISTRO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "La fecha de pedido no puede estar vacía")
    @Column(name = "fecha_pedido")
    private Date fechaPedido;

    @NotBlank(message = "El estado del pedido es requerido")
    @Column(name = "estado_pedido", length = 50)
    private String estadoPedido;

    @NotNull(message = "El ID del cliente es requerido")
    @Column(name = "cliente_id")
    private Integer clienteId;

    // GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    // CONSTRUCTORES
    public Pedido() {
    }

    public Pedido(Integer id, @NotNull(message = "La fecha de pedido no puede estar vacía") Date fechaPedido,
                  @NotBlank(message = "El estado del pedido es requerido") String estadoPedido,
                  @NotNull(message = "El ID del cliente es requerido") Integer clienteId) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.estadoPedido = estadoPedido;
        this.clienteId = clienteId;
    }
}
