package controller;

import java.util.ArrayList;

import model.Pessoa;

public class CadastrarCliente {
	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private ValidaCliente valida = new ValidaCliente();
	
	public void cadastrarNovoCliente(Pessoa pessoa) throws Exception{
		boolean isClienteType = valida.validaTipoCliente(pessoa);
		if(isClienteType){
			boolean existeCliente = valida.validaClienteExistente(pessoa);
			if (!existeCliente){
				boolean adicionar = listaPessoas.add(pessoa);
				if (!adicionar){
					throw new Exception("Falha ao cadastrar cliente. Tente novamente.");
				}
			}
		}
	}
}