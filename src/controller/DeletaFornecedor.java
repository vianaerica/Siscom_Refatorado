package controller;

import java.util.ArrayList;
import model.Fornecedor;
import model.Pessoa;

public class DeletaFornecedor {
	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private ValidaDeletaFornecedor valida = new ValidaDeletaFornecedor();

	public void excluirForncededorValidandoSeTemCompra (Pessoa pessoa) throws Exception{
		valida.validaFornecedorAntesDeExcluir(pessoa);
		removeDaListaFornecedor(pessoa);
	}

	private void removeDaListaFornecedor(Pessoa pessoa) throws Exception{
		Fornecedor fornecedor = (Fornecedor) pessoa;
		for (Pessoa pessoaForn : listaPessoas) {
			Fornecedor fornExistente = (Fornecedor) pessoaForn;
			if (fornecedor.getCnpj().equals(fornExistente.getCnpj())){
				listaPessoas.remove(pessoa);
			}
		}
	}
}