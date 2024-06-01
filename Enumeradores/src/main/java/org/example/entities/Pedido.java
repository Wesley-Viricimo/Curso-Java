package org.example.entities;

import org.example.entities.enums.StatusPedido;

import java.util.Date;

public class Pedido {
    private Integer id;
    private Date data;
    private StatusPedido status;

    public Pedido() {}

    public Pedido(Integer id, Date data, StatusPedido status) {
        this.id = id;
        this.data = data;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", data=" + data +
                ", status=" + status +
                '}';
    }
}
