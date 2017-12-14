package controller;

import java.util.ArrayList;

import model.Cliente;
import model.Pessoa;
import model.Venda;

public class GerenciaCliente {
	
	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private ValidaCliente valida = new ValidaCliente();

	public ArrayList<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public int gerarCodigoClienteSequencial(){
		return getListaPessoas().isEmpty() ? 1 : getListaPessoas().size() + 1;
	}

	public Cliente pesquisarClientesPorCpf(String cpf) throws Exception{
		for (Pessoa pessoa : listaPessoas) {
			boolean tipo = valida.validaTipoCliente(pessoa);
			if (tipo == true){
				Cliente cliente = (Cliente) pessoa;
				if (cliente.getCpf().equals(cpf)) {
					return cliente;
				}
				else{ 
					throw new Exception("Não foi encontrado cliente com o CPF informado.");
				}
			}
		}
		return null;
	}


	private void removeDaListaClientes(Pessoa pessoa) throws Exception{
		Cliente cliente = (Cliente) pessoa;
		for (Pessoa pessoaCli : listaPessoas) {
			Cliente aux = (Cliente) pessoaCli;
			if (cliente.getCpf().equals(aux.getCpf())){
				boolean excluir = getListaPessoas().remove(pessoa);
				if (!excluir) {
					throw new Exception("Falha ao excluir cliente. Tente novamente.");
				}
			}
		}
	}
	
	public void excluirClienteValidandoSeTemVenda(Pessoa pessoa) throws Exception{
		boolean tipo = valida.validaTipoCliente(pessoa);
		if (tipo == true){
			boolean	possuiVenda = valida.validaSeTemVendaParaCliente(pessoa);
			if(possuiVenda == true){
				throw new Exception("O cliente está vinculado à uma venda. Não é possível excluir.");
			}
			else{
				removeDaListaClientes(pessoa);
			}
		}
	}

}
