package model;

import java.util.Date;
import java.io.Serializable;

public abstract class Pessoa implements Comparable<Pessoa>, Serializable{

	private int codigo;
	private String nome;
	private String telefones;
	private String email;
	private Date dataCad;

	public static final int CLIENTE = 0;
	public static final int VEND = 1;
	public static final int FORN = 2;

	public abstract int getTipoPessoa();


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

	public String getTelefones() {
		return telefones;
	}

	public void setTelefones(String telefones) {
		this.telefones = telefones;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataCad() {
		return dataCad;
	}

	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}

	public Pessoa(int codigo, String nome, String telefones, String email, Date dataCad) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.telefones = telefones;
		this.email = email;
		this.dataCad = dataCad;
	}

	@Override
	public String toString() {
		return "Pessoa:"
				+ "\nCódigo: " + codigo 
				+ "\nNome: " + nome 
				+ "\nTelefones: " + telefones 
				+ "\nE-mail:" + email
				+ "\nData de Cadastro: " + dataCad;
	}

	public int compareTo(Pessoa pessoa){
		return this.nome.compareTo(pessoa.getNome());
	}

}
