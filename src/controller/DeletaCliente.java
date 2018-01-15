package controller;

import java.util.ArrayList;
import model.Cliente;
import model.Pessoa;

public class DeletaCliente {
	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private ValidaDeletaCliente valida = new ValidaDeletaCliente();

	public void excluirClienteValidandoSeTemVenda(Pessoa pessoa) throws Exception{
		valida.validaClienteAntesDeExcluir(pessoa);
		removeDaListaClientes(pessoa);
	}
	
	private void removeDaListaClientes(Pessoa pessoa) throws Exception{
		Cliente cliente = (Cliente) pessoa;
		for (Pessoa pessoaCli : listaPessoas) {
			Cliente clienteExistente = (Cliente) pessoaCli;
			if (cliente.getCpf().equals(clienteExistente.getCpf())){
				listaPessoas.remove(pessoa);
			}
		}
	}
}