package com.navent.backend.pedidos.util;

import com.navent.backend.pedidos.model.Pedido;

public class PedidoBuilder implements IBuilder {
    private long idPedido;
    private String nombre;
    private double monto; 
    private float descuento;

    @Override
    public Pedido build() {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(this.idPedido);
        pedido.setNombre(this.nombre);
        pedido.setMonto(this.monto);
        pedido.setDescuento(this.descuento);
        return pedido;
    }

    public PedidoBuilder withIPedido(long idPedido){
        this.idPedido = idPedido;
        return this;
    }

    public PedidoBuilder withNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public PedidoBuilder withMonto(double monto){
        this.monto = monto;
        return this;
    }

    public PedidoBuilder withDescuento(float descuento){
        this.descuento = descuento;
        return this;
    }
}