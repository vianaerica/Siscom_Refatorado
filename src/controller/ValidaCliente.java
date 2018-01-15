package controller;

import java.util.ArrayList;
import model.Cliente;
import model.Pessoa;

public class ValidaCliente {

	private ArrayList<Pessoa> listaPessoas;

	public ValidaCliente(ArrayList<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public void validaClienteAntesDoCadastro(Pessoa pessoa) throws Exception{
		validaTipoCliente(pessoa);
		validaClienteExistente(pessoa);
	}

	private void validaTipoCliente(Pessoa pessoa) throws Exception{
		if (pessoa.getTipoPessoa() != 0){
			throw new Exception("A pessoa não é do tipo cliente.");
		}
	}

	private void validaClienteExistente(Pessoa pessoa) throws Exception{
		Cliente cliente = (Cliente) pessoa;
		for (Pessoa pessoaCliente : listaPessoas) {
			Cliente clienteExistente = (Cliente) pessoaCliente;
			if (cliente.getCpf().equals(clienteExistente.getCpf())){
				throw new Exception("O cliente não pode ser cadastrado. O CPF informado já existe.");
			}
		}
	}
}