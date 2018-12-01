package com.pedido.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido.model.Pedido;
import com.pedido.repositories.PedidoRepository;

@Service
public class PedidoBean {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido salvar(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
}
