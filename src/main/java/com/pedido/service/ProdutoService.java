package com.pedido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido.bean.ProdutoBean;
import com.pedido.model.Produto;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoBean produtoBean;
	
	public List<Produto> localizarMaisDeUmPorId(String ids) {
		return produtoBean.localizarMaisDeUmPorId(ids);
	}
}
