package com.pedido.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedido.demo.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
}
