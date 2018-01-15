package controller;

import java.util.ArrayList;
import model.Pessoa;

public class CadastroFornecedor {
	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private ValidaFornecedor valida = new ValidaFornecedor(listaPessoas);

	public void cadastrarNovoFornecedor(Pessoa pessoa) throws Exception{
		valida.validaFornecedorAntesDoCadastro(pessoa);
		listaPessoas.add(pessoa);
	}
}