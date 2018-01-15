package controller;

import java.util.ArrayList;
import model.Fornecedor;
import model.Pessoa;

public class ValidaPesquisaFornecedor {
	private ArrayList<Pessoa> listaPessoas;

	public ValidaPesquisaFornecedor(ArrayList<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public void validaFornecedorAntesDaPesquisa(Pessoa pessoa, String cnpj) throws Exception{
		validaTipoFornecedor(pessoa);
		validaFornecedorInexistente(cnpj);
	}

	private void validaTipoFornecedor(Pessoa pessoa) throws Exception{
		if (pessoa.getTipoPessoa() != 2){
			throw new Exception("A pessoa não é do tipo fornecedor.");
		}
	}

	private void validaFornecedorInexistente(String cnpj) throws Exception{
		for (Pessoa pessoaForn : listaPessoas) {
			Fornecedor forn = (Fornecedor) pessoaForn;
			if (!forn.getCnpj().equals(cnpj)) {
				throw new Exception("Não existe fornecedor cadastrado com o CNPJ informado.");
			}
		}
	}
}