package controller;

import java.util.ArrayList;
import model.Fornecedor;
import model.Pessoa;

public class PesquisaFornecedor {
	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private ValidaPesquisaFornecedor valida = new ValidaPesquisaFornecedor(listaPessoas);

	public Fornecedor pesquisarFornecedorPorCnpj(String cnpj) throws Exception{
		for (Pessoa pessoaForn : listaPessoas) {
			valida.validaFornecedorAntesDaPesquisa(pessoaForn, cnpj);
			Fornecedor fornecedor = (Fornecedor) pessoaForn;
			if (fornecedor.getCnpj().equals(cnpj)) {
				return fornecedor;
			}
		}
		return null;
	}
}