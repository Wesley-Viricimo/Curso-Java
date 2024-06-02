package org.example.entities;

import org.example.entities.enums.StatusPedido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Date dataPedido;
    private Cliente cliente;
    private StatusPedido statusPedido;
    private List<ItensPedido> itensPedido = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Date dataPedido, Cliente cliente, StatusPedido statusPedido) {
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.statusPedido = statusPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public List<ItensPedido> getItensPedido() {
        return itensPedido;
    }

    public void addItem(ItensPedido itemPedido) {
        itensPedido.add(itemPedido);
    }

    public void removeItem(ItensPedido itemPedido) {
        itensPedido.remove(itemPedido);
    }

    public double getTotal() {
        double soma = 0;
        for (ItensPedido item : itensPedido) {
            soma += item.getQuantidade() * item.getProduto().getPreco();
        }
        return soma;
    }
}
