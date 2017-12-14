package controller;

import java.util.ArrayList;
import model.Cliente;
import model.Pessoa;
import model.Venda;

public class ValidaCliente {

	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();

	public boolean validaTipoCliente(Pessoa pessoa) throws Exception{
		boolean cliente = false;
		if (pessoa.getTipoPessoa() == 0){
			cliente = true;
		}
		return cliente;
	}
	
	public boolean validaClienteExistente(Pessoa pessoa) throws Exception{
		boolean existe = false;
		Cliente cliente = (Cliente) pessoa;
		for (Pessoa pessoaCliente : listaPessoas) {
			Cliente auxiliar = (Cliente) pessoaCliente;
			if (cliente.getCpf().equals(auxiliar.getCpf())){
				existe = true;
				throw new Exception("O CPF informado já está cadastrado.");
			}
		}
		return existe;
	}
	

	public boolean validaSeTemVendaParaCliente(Pessoa pessoa) throws Exception{
		boolean possuiVenda = false;
		Venda venda = new Venda();
		Cliente cliente = (Cliente) pessoa;
		if (venda.getCliente() == cliente){
			possuiVenda = true;
		}
		return possuiVenda;
	}
	
}
