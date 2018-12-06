package com.pedido.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido.model.Entrega;
import com.pedido.repositories.EntregaRepository;

@Service
public class EntregaBean {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	public List<Entrega> salvar(List<Entrega> entregas) {
		return entregaRepository.saveAll(entregas);
	}
}
