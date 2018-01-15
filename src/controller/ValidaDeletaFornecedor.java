package controller;

import model.Fornecedor;
import model.Pessoa;
import model.Compra;

public class ValidaDeletaFornecedor {
private Compra compra = new Compra();
	
	public void validaFornecedorAntesDeExcluir(Pessoa pessoa) throws Exception{
		validaTipoFornecedor(pessoa);
		validaSeTemCompraParaFornecedor(pessoa);
	}
	
	private void validaSeTemCompraParaFornecedor(Pessoa pessoa) throws Exception{
		Fornecedor forn = (Fornecedor) pessoa;
		if (compra.getFornecedor() == forn){
			throw new Exception("O fornecedor está vinculado à uma compra. Não é possível excluir.");
		}
	}
	
	private void validaTipoFornecedor(Pessoa pessoa) throws Exception{
		if (pessoa.getTipoPessoa() != 2){
			throw new Exception("A pessoa não é do tipo fornecedor.");
		}
	}

}