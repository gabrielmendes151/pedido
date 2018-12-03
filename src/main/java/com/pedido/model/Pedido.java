package com.pedido.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Pedido() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_pedido")
	private Long idPedido;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	private Cliente cliente;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido")
	private List<ItensPedido> itensPedido;
	
	@Column(name="valor_total")
	private double valorTotal;
	
	@Column(name="endereco_entrega")
	private String enderecoEntrega;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/*public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}*/

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	
}

