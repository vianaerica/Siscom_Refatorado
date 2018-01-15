package controller;

import java.util.ArrayList;
import model.Pessoa;

public class CadastroCliente {
	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private ValidaCliente valida = new ValidaCliente(listaPessoas);

	public void cadastrarNovoCliente(Pessoa pessoa) throws Exception{
		valida.validaClienteAntesDoCadastro(pessoa);
		listaPessoas.add(pessoa);
	}
}