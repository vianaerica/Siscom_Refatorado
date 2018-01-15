package controller;

import java.util.ArrayList;
import model.Pessoa;
import model.Vendedor;

public class ValidaPesquisaVendedor {
	private ArrayList<Pessoa> listaPessoas;
	
	public ValidaPesquisaVendedor(ArrayList<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public void validaVendedorAntesDaPesquisa(Pessoa pessoa, String cpf) throws Exception{
		validaTipoVendedor(pessoa);
		validaVendedorInexistente(cpf);
	}

	private void validaTipoVendedor(Pessoa pessoa) throws Exception{
		if (pessoa.getTipoPessoa() != 1){
			throw new Exception("A pessoa não é do tipo vendedor.");
		}
	}

	private void validaVendedorInexistente(String cpf) throws Exception{
		for (Pessoa pessoaVend : listaPessoas) {
			Vendedor vend = (Vendedor) pessoaVend;
			if (!vend.getCpf().equals(cpf)) {
				throw new Exception("Não existe vendedor cadastrado com o CPF informado.");
			}
		}
	}
}