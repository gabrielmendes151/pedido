package com.pedido.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itens_pedido")
public class ItensPedido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_itens_pedido")
	private Long idItensPedido;
	
	@ManyToOne
	@JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
	private Pedido pedido;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
