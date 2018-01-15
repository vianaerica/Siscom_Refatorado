package model;

import java.awt.HeadlessException;
import java.io.Serializable;

public class ItemCompra implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Produto produto;
	private int quantCompra;
	private double valorCompra;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantCompra() {
		return quantCompra;
	}

	public void setQuantCompra(int quantCompra) {
		this.quantCompra = quantCompra;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public ItemCompra(Produto produto, int quantCompra, double valorCompra) throws HeadlessException {
		super();
		this.produto = produto;
		this.quantCompra = quantCompra;
		this.valorCompra = valorCompra;
	}

	@Override
	public String toString() {
		return "Item de Compra: "
				+ "\nQuantidade de Compra: " + quantCompra 
				+ ",\nValor da Compra: " + valorCompra
				+ "\nProduto: " + produto;
	}
}
