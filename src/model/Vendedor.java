package model;

import java.util.Date;

public class Vendedor extends Pessoa {

	private String cpf;
	private double metaMensal;


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getMetaMensal() {
		return metaMensal;
	}

	public void setMetaMensal(double metaMensal) {
		this.metaMensal = metaMensal;
	}

	public Vendedor(int codigo, String nome, String telefones, String email, Date dataCad) {
		super(codigo, nome, telefones, email, dataCad);
	}

	public Vendedor(int codigo, String nome, String telefones, String email, Date dataCad, String cpf,
			double metaMensal) {
		super(codigo, nome, telefones, email, dataCad);
		this.cpf = cpf;
		this.metaMensal = metaMensal;
	}
	
	@Override
	public String toString() {
		return "Vendedor: "
				+ "\nCPF: " + cpf 
				+ "\nMeta Mensal: " + metaMensal 
				+ "\nCódigo: " + getCodigo() 
				+ "\nNome: " + getNome() 
				+ "\nTelefones: " + getTelefones() 
				+ "\nE-mail: " + getEmail() 
				+ "\nData de Cadastro: " + getDataCad();
	}

	public int getTipoPessoa(){
		return Pessoa.VEND;
	}
}
