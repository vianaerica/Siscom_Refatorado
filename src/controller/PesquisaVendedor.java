package controller;

import java.util.ArrayList;
import model.Pessoa;
import model.Vendedor;

public class PesquisaVendedor {
	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private ValidaPesquisaVendedor valida = new ValidaPesquisaVendedor(listaPessoas);

	public Vendedor pesquisarVendedorPorCpf(String cpf) throws Exception{
		for (Pessoa pessoaVend : listaPessoas) {
			valida.validaVendedorAntesDaPesquisa(pessoaVend, cpf);
			Vendedor vendedor = (Vendedor) pessoaVend;
			if (vendedor.getCpf().equals(cpf)) {
				return vendedor;
			}
		}
		return null;
	}
}