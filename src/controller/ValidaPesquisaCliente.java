package controller;

import java.util.ArrayList;
import model.Cliente;
import model.Pessoa;

public class ValidaPesquisaCliente {
	private ArrayList<Pessoa> listaPessoas;

	public ValidaPesquisaCliente(ArrayList<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public void validaClienteAntesDaPesquisa(Pessoa pessoa, String cpf) throws Exception{
		validaTipoCliente(pessoa);
		validaClienteInexistente(cpf);
	}

	private void validaTipoCliente(Pessoa pessoa) throws Exception{
		if (pessoa.getTipoPessoa() != 0){
			throw new Exception("A pessoa não é do tipo cliente.");
		}
	}

	private void validaClienteInexistente(String cpf) throws Exception{
		for (Pessoa pessoaCliente : listaPessoas) {
			Cliente cliente = (Cliente) pessoaCliente;
			if (!cliente.getCpf().equals(cpf)) {
				throw new Exception("Não existe cliente cadastrado com o CPF informado.");
			}
		}
	}
}