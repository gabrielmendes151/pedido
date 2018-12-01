package com.pedido.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedido.demo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}
