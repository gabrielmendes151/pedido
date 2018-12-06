package com.pedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedido.model.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long>{
	
}
