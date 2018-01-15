package model;

import java.awt.HeadlessException;
import java.util.Date;
import java.util.ArrayList;
import java.io.Serializable;


public class Venda implements Serializable{
	private static final long serialVersionUID = 1L;

	private int numVenda;
	private Cliente cliente;
	private Vendedor vendedor;
	private ArrayList<ItemVenda> vendaItens = new ArrayList<ItemVenda>();
	private int formaPagto; //(1-Pagto á Vista; 2-Pagto a prazo – cheque pré-datado)
	private Date dataVenda;

	public int getNumVenda() {
		return numVenda;
	}

	public void setNumVenda(int numVenda) {
		this.numVenda = numVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public ArrayList<ItemVenda> getVendaItens() {
		return vendaItens;
	}

	public void setVendaItens(ArrayList<ItemVenda> vendaItens) {
		this.vendaItens = vendaItens;
	}

	public int getFormaPagto() {
		return formaPagto;
	}

	public void setFormaPagto(int formaPagto) {
		this.formaPagto = formaPagto;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public Venda(int numVenda, Cliente cliente, Vendedor vendedor, ArrayList<ItemVenda> vendaItens, int formaPagto,
			Date dataVenda) throws HeadlessException {
		super();
		this.numVenda = numVenda;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.vendaItens = vendaItens;
		this.formaPagto = formaPagto;
		this.dataVenda = dataVenda;
	}

	public Venda(){
		super();
	}

	@Override
	public String toString() {
		return "Venda: "
				+ "\nNúmero da Venda: " + numVenda 
				+ "\nCliente: " + cliente 
				+ "\nVendedor: " + vendedor 
				+ "\nForma de Pagamento: " + formaPagto 
				+ "\nData da Venda: " + dataVenda;
	}

}
