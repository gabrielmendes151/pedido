package com.pedido.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedido.helper.Receiver;
import com.pedido.model.Entrega;
import com.pedido.service.EntregaService;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
	
	@Autowired
	private EntregaService entregaService;
	
	@GetMapping
	ResponseEntity<List<Entrega>> pegarDaFilaESalvarEntregas() throws IOException, TimeoutException, InterruptedException{
		List<Entrega> entregas = new ArrayList<>();
		String[] fila = Receiver.pegarMensagemDaFila();
		if(fila!=null) {
			for (String item : fila) {
				Entrega entrega = new Entrega();
				String[] split = item.split(" - ");
				entrega.setIdPedido(Integer.parseInt(split[0]));
				entrega.setEnderecoEntrega(split[1]);
				entregas.add(entrega);
			}
			return ResponseEntity.ok(entregaService.salvar(entregas));
		}else {
			return null;
		}
	}
}
