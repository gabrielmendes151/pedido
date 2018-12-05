package com.pedido;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.pedido.model.Cliente;
import com.pedido.model.ItensPedido;
import com.pedido.model.Pedido;
import com.pedido.model.Produto;
import com.pedido.service.PedidoService;
import com.pedido.service.ProdutoService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class PedidoApplicationTests {
	
	@LocalServerPort
    int serverPort;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Test
	public void testarSalvarPedido() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + serverPort + "/pedido";
		URI uri = new URI(baseUrl);
		
		List<Produto> produtos = produtoService.localizarMaisDeUmPorId("1,2");
		List<ItensPedido>itensPedidos = new ArrayList<>();
		ItensPedido item1 = new ItensPedido();
		ItensPedido item2 = new ItensPedido();
		item1.setProduto(produtos.get(0));
		item2.setProduto(produtos.get(1));
		itensPedidos.add(item1);
		itensPedidos.add(item2);
		Cliente cliente = new Cliente();
		cliente.setNome("GabrielMendes");
		cliente.setCodigo("00012x");
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setEnderecoEntrega("Rua goias");
		pedido.setItensPedido(itensPedidos);
		pedido.setValorTotal(200D);
		
		
		HttpEntity<Pedido> request = new HttpEntity<Pedido>(pedido, new HttpHeaders());
		
		ResponseEntity<Pedido> result = restTemplate.postForEntity(uri, request, Pedido.class);
		
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().getIdPedido() > 0);
	}

}
