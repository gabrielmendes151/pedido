package com.pedido.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.pedido.model.Produto;

@Service
public class ProdutoBean {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Produto> localizarMaisDeUmPorId(String ids) {
		try {
			String sql = "select o from Produto o where o.idProduto in ("+ids+")";
			return em.createQuery(sql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		
	}
}
