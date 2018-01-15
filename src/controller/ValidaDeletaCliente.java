package controller;

import model.Cliente;
import model.Pessoa;
import model.Venda;

public class ValidaDeletaCliente {
	private Venda venda = new Venda();
	
	public void validaClienteAntesDeExcluir(Pessoa pessoa) throws Exception{
		validaTipoCliente(pessoa);
		validaSeTemVendaParaCliente(pessoa);
	}
	
	private void validaSeTemVendaParaCliente(Pessoa pessoa) throws Exception{
		Cliente cliente = (Cliente) pessoa;
		if (venda.getCliente() == cliente){
			throw new Exception("O cliente está vinculado à uma venda. Não é possível excluir.");
		}
	}
	
	private void validaTipoCliente(Pessoa pessoa) throws Exception{
		if (pessoa.getTipoPessoa() != 0){
			throw new Exception("A pessoa não é do tipo cliente.");
		}
	}
}