package com.navent.backend.pedidos.repository;

import com.navent.backend.pedidos.model.Pedido;


public class PedidosDAO {
    
    public static void insertOrUpdate(Pedido pedido){
        //inserta un nuevo pedido en la base de datos o
        //modifica un pedido existente (en cado de crear uno nuevo, el pedido pasado como
        //parámetro se completa con el nuevo id).
        
    }
    
    public static void delete(Integer pedido){
        //elimina el pedido que corresponde al id recibido.
    }

    public static Pedido select(Integer idPedido){
        //busca un pedido por id.
        return null;
    }
}