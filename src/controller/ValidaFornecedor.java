package controller;

import java.util.ArrayList;
import model.Fornecedor;
import model.Pessoa;

public class ValidaFornecedor {
	private ArrayList<Pessoa> listaPessoas;

	public ValidaFornecedor(ArrayList<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public void validaFornecedorAntesDoCadastro(Pessoa pessoa) throws Exception{
		validaTipoFornecedor(pessoa);
		validaFornecedorExistente(pessoa);
	}

	private void validaTipoFornecedor(Pessoa pessoa) throws Exception{
		if (pessoa.getTipoPessoa() != 2){
			throw new Exception("A pessoa não é do tipo fornecedor.");
		}
	}

	private void validaFornecedorExistente(Pessoa pessoa) throws Exception{
		Fornecedor fornecedor = (Fornecedor) pessoa;
		for (Pessoa pessoaForn : listaPessoas) {
			Fornecedor fornExistente = (Fornecedor) pessoaForn;
			if (fornecedor.getCnpj().equals(fornExistente.getCnpj())){
				throw new Exception("O CNPJ informado já está cadastrado.");
			}
		}
	}
}