package model;

import java.util.Date;

public class Fornecedor extends Pessoa {

	private String cnpj;
	private String nomeContato;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public Fornecedor(int codigo, String nome, String telefones, String email, Date dataCad) {
		super(codigo, nome, telefones, email, dataCad);
	}

	public Fornecedor(int codigo, String nome, String telefones, String email, Date dataCad, String cnpj,
			String nomeContato) {
		super(codigo, nome, telefones, email, dataCad);
		this.cnpj = cnpj;
		this.nomeContato = nomeContato;
	}


	@Override
	public String toString() {
		return "Fornecedor:"
				+ "\nCNPJ: " + cnpj 
				+ "Nome do Contato: " + nomeContato 
				+ "Código: " + getCodigo() 
				+ "Nome: " + getNome()
				+ "Telefones:" + getTelefones() 
				+ "E-mail: " + getEmail() 
				+ "Data do Cadastro: " + getDataCad();
	}

	public int getTipoPessoa(){
		return Pessoa.FORN;
	}

}
