package controller;

import model.Pessoa;
import model.Venda;
import model.Vendedor;

public class ValidaDeletaVendedor {
	private Venda venda = new Venda();
	
	public void validaVendedorAntesDeExcluir(Pessoa pessoa) throws Exception{
		validaTipoVendedor(pessoa);
		validaSeTemVendaParaVendedor(pessoa);
	}
	
	private void validaTipoVendedor(Pessoa pessoa) throws Exception{
		if (pessoa.getTipoPessoa() != 1){
			throw new Exception("A pessoa n�o � do tipo vendedor.");
		}
	}
	
	private void validaSeTemVendaParaVendedor(Pessoa pessoa) throws Exception{
		Vendedor vend = (Vendedor) pessoa;
		if (venda.getVendedor() == vend){
			throw new Exception("O vendedor est� vinculado � uma venda. N�o � poss�vel excluir.");
		}
	}
}