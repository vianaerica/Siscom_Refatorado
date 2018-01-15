package controller;

import java.util.ArrayList;
import model.Pessoa;
import model.Vendedor;

public class DeletaVendedor {
	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private ValidaDeletaVendedor valida = new ValidaDeletaVendedor();

	public void excluirVendedorValidandoSeTemVenda(Pessoa pessoa) throws Exception{
		valida.validaVendedorAntesDeExcluir(pessoa);
		removeDaListaVendedor(pessoa);
	}

	private void removeDaListaVendedor(Pessoa pessoa) throws Exception{
		Vendedor vendedor = (Vendedor) pessoa;
		for (Pessoa pessoaVendedor : listaPessoas) {
			Vendedor vendedorExistente = (Vendedor) pessoaVendedor;
			if (vendedor.getCpf().equals(vendedorExistente.getCpf())){
				listaPessoas.remove(pessoa);	
			}
		}
	}
}