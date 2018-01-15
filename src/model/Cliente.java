package model;

import java.util.Date;

public class Cliente extends Pessoa {
	
	private String cpf;
	private double limiteCredito;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito){
		this.limiteCredito = limiteCredito;
	}
	
	public Cliente(int codigo, String nome, String telefones, String email, Date dataCad) {
		super(codigo, nome, telefones, email, dataCad);
	}

	public Cliente(int codigo, String nome, String telefones, String email, Date dataCad, String cpf,
			double limiteCredito) {
		super(codigo, nome, telefones, email, dataCad);
		this.cpf = cpf;
		this.limiteCredito = limiteCredito;
	}

	@Override
	public String toString() {
		return "Cliente:"
				+ "\nCPF: " + cpf
				+ "\nLimite de Crédito: " + limiteCredito 
				+ "\nCódigo: " + getCodigo() 
				+ "\nNome: " + getNome() 
				+ "\nTelefones: " + getTelefones() 
				+ "\nE-mail: " + getEmail() 
				+ "\nData do Cadastro: " + getDataCad();
	}

	public int getTipoPessoa(){
		return Pessoa.CLIENTE;
	}

}
