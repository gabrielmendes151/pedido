package com.pedido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido.bean.PedidoBean;
import com.pedido.model.Pedido;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoBean pedidoBean;
	
	public Pedido salvar(Pedido pedido) {
		return pedidoBean.salvar(pedido);
		//gravar rabbit
	}
}
