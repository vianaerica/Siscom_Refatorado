package controller;

import java.util.ArrayList;
import model.Cliente;
import model.Pessoa;

public class PesquisaCliente {
	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private ValidaPesquisaCliente valida = new ValidaPesquisaCliente(listaPessoas);

	public Cliente pesquisarClientePorCpf(String cpf) throws Exception{
		for (Pessoa pessoaCliente : listaPessoas) {
			valida.validaClienteAntesDaPesquisa(pessoaCliente, cpf);
			Cliente cliente = (Cliente) pessoaCliente;
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		return null;
	}
}