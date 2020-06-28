package com.navent.backend.pedidos.cache;

import com.navent.backend.pedidos.model.Pedido;
import com.navent.backend.pedidos.repository.PedidosDAO;

import org.springframework.stereotype.Component;

@Component
public class PedidoCacheManager {
    private BumexMemcached cache;

    public PedidoCacheManager(){
        cache = BumexMemcached.getInstance();
    }

	public void createPedido(Pedido pedido) throws Exception {

        Pedido existingPedido = (Pedido) this.cache.get(Long.toString(pedido.getIdPedido())); //getting the product if it exists
        
        //already exists the product?
        if(existingPedido == null) {
            PedidosDAO.insertOrUpdate(pedido);
            this.cache.set(Long.toString(pedido.getIdPedido()), pedido);
        }
	}

	public void updatePedido(Pedido existingPedido) throws Exception {
        PedidosDAO.insertOrUpdate(existingPedido);//Update the database
        this.cache.set(Long.toString(existingPedido.getIdPedido()), existingPedido);//Update the cache
	}
	
	public void deletePedido(Integer id) throws Exception {
        PedidosDAO.delete(id);
        this.cache.delete(Long.toString(id));
	}

	public Pedido getPedido(Integer id) throws Exception {
        Pedido pedido = (Pedido) this.cache.get(Long.toString(id));
    
        if(pedido == null ) {
            pedido = PedidosDAO.select(id);
        }
        return pedido;
    }
    
}