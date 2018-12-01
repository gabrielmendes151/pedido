package com.pedido.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedido.demo.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
}
