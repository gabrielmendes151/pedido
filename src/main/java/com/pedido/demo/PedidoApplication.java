package com.pedido.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pedido.demo.model.Pedido;
import com.pedido.demo.repositories.PedidoRepository;

@SpringBootApplication
public class PedidoApplication {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PedidoApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner commandLineRunner() {
		Pedido pedido = new Pedido();
		
		pedido.setCliente();
		pedidoRepository.save(entity)
	}*/
	
}
