package model;

import java.util.Date;
import java.io.Serializable;

public class Produto implements Comparable<Produto>, Serializable{
	private static final long serialVersionUID = 1L;

	private int codigo;
	private String nome;
	private double precoUnitario;
	private int estoque;
	private int estoqueMinimo;
	private Date dataCad;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public Date getDataCad() {
		return dataCad;
	}

	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}

	public Produto(int codigo, String nome, double precoUnitario, int estoque, int estoqueMinimo,
			Date dataCad) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.estoque = estoque;
		this.estoqueMinimo = estoqueMinimo;
		this.dataCad = dataCad;
	}

	public Produto(){
		super();
	}

	@Override
	public String toString() {
		return "Produto: "
				+ "\nC�digo: " + codigo 
				+ "\nNome: " + nome 
				+ "\nPre�o Unit�rio: " + precoUnitario 
				+ "\nEstoque: " + estoque 
				+ "\nEstoque Minimo: " + estoqueMinimo 
				+ "\nData de Cadastro: " + dataCad;
	}

	public void adicionaQuantidadeDeProdutoNoEstoque(int quantidadeAddProduto){
		estoque = 0;
		estoque = quantidadeAddProduto;
	}

	public void decrementaQuantidadeDeProdutoNoEstoque(int quantidadeDecrementaProduto){
		try{
			estoque = estoque - quantidadeDecrementaProduto;
		}catch (Exception e){
			SisComException ex = new SisComException(nome, estoque, "Estoque Insuficiente.");
		}
	}

	public int compareTo(Produto produto){
		return this.nome.compareTo(produto.getNome());
	}

}
