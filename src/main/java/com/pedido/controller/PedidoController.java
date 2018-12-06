package com.pedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedido.helper.Sender;
import com.pedido.model.Pedido;
import com.pedido.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping(produces = "application/json")
	ResponseEntity<Pedido>inserir(@RequestBody Pedido pedido){
		ResponseEntity<Pedido> ok = ResponseEntity.ok(pedidoService.salvar(pedido));
		Sender.enviarMensagem(pedido);
		return ok;
	}
}
