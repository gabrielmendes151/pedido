package com.pedido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido.bean.EntregaBean;
import com.pedido.model.Entrega;

@Service
public class EntregaService {
	
	@Autowired
	private EntregaBean entregaBean;
	
	public List<Entrega> salvar(List<Entrega> entregas) {
		return entregaBean.salvar(entregas);
	}
}
