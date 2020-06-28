package com.navent.backend.pedidos.rest;

import com.navent.backend.pedidos.cache.PedidoCacheManager;
import com.navent.backend.pedidos.model.Pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidosRestController {

    @Autowired
    private PedidoCacheManager cacheManager;

    @GetMapping(value = "/{id}")
    public Pedido getPedido(@PathVariable("id") Integer id) throws Exception {
        return cacheManager.getPedido(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insert(@RequestBody Pedido pedido) throws Exception {
        cacheManager.createPedido(pedido);
    }

    @PutMapping(value = "/{id}")
    public void update(@RequestBody Pedido pedido) throws Exception {
        cacheManager.updatePedido(pedido);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        cacheManager.deletePedido(id);
    }


}