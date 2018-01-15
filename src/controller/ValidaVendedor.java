package controller;

import java.util.ArrayList;
import model.Pessoa;
import model.Vendedor;

public class ValidaVendedor {
	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();

	public ValidaVendedor(ArrayList<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public void validaVendedorAntesDoCadastro(Pessoa pessoa) throws Exception{
		validaTipoVendedor(pessoa);
		validaVendedorExistente(pessoa);
	}
	
	private void validaTipoVendedor(Pessoa pessoa) throws Exception{
		if (pessoa.getTipoPessoa() != 1){
			throw new Exception("A pessoa não é do tipo vendedor.");
		}
	}
	
	private void validaVendedorExistente(Pessoa pessoa) throws Exception{
		Vendedor vend = (Vendedor) pessoa;
		for (Pessoa pessoaVend : listaPessoas) {
			Vendedor vendedorExistente = (Vendedor) pessoaVend;
			if (vend.getCpf().equals(vendedorExistente.getCpf())){
				throw new Exception("O vendedor não pode ser cadastrado. O CPF informado já existe.");
			}
		}
	}
}