package com.navent.backend.pedidos.pedidos;

import com.navent.backend.pedidos.cache.PedidoCacheManager;
import com.navent.backend.pedidos.rest.PedidosRestController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {PedidosRestController.class,PedidoCacheManager.class})
@EntityScan("com.navent.backend.pedidos.model")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		
	}

}
