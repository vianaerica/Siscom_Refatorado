package model;

import java.awt.HeadlessException;
import java.util.Date;
import java.util.ArrayList;
import java.io.Serializable;


public class Compra implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Fornecedor fornecedor;
	private ArrayList<ItemCompra> compraItens = new ArrayList<ItemCompra>();
	private int numCompra;
	private Date dataCompra;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public ArrayList<ItemCompra> getCompraItens() {
		return compraItens;
	}

	public void setCompraItens(ArrayList<ItemCompra> compraItens) {
		this.compraItens = compraItens;
	}

	public int getNumCompra() {
		return numCompra;
	}

	public void setNumCompra(int numCompra) {
		this.numCompra = numCompra;
	}
	
	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Compra(Fornecedor fornecedor, ArrayList<ItemCompra> compraItens, int numCompra, Date dataCompra)
			throws HeadlessException {
		super();
		this.fornecedor = fornecedor;
		this.compraItens = compraItens;
		this.numCompra = numCompra;
		this.dataCompra = dataCompra;
	}
	
	public Compra(){
		super();
	}

	@Override
	public String toString() {
		return "Compra: "
				+ "\nFornecedor: " + fornecedor 
				+ "\nCompra de Itens: " + compraItens 
				+ "\nNúmero da Compra: " + numCompra
				+ "\nData da Compra: " + dataCompra;
	}
}
