package controller;

import java.util.ArrayList;
import model.Pessoa;

public class CadastroVendedor {
	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private ValidaVendedor valida = new ValidaVendedor(listaPessoas);
	
	public void cadastrarNovoVendedor(Pessoa pessoa) throws Exception{
		valida.validaVendedorAntesDoCadastro(pessoa);
		listaPessoas.add(pessoa);
	}
}