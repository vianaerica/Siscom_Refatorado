package controller;

import java.util.ArrayList;
import model.Compra;
import model.Fornecedor;
import model.Pessoa;

public class GerenciaFornecedor {

	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();

	public ArrayList<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	private boolean validaTipoFornecedor(Pessoa pessoa) throws Exception{
		boolean fornecedor = false;
		if (pessoa.getTipoPessoa() == 2){
			fornecedor = true;
		}
		return fornecedor;
	}

	public boolean validaFornecedorExistente(Pessoa pessoa) throws Exception{
		boolean existe = false;
		Fornecedor forn = (Fornecedor) pessoa;
		for (Pessoa pessoaForn : listaPessoas) {
			Fornecedor auxiliar = (Fornecedor) pessoaForn;
			if (forn.getCnpj().equals(auxiliar.getCnpj())){
				existe = true;
				throw new Exception("O CNPJ informado já está cadastrado.");
			}
		}
		return existe;
	}

	public void cadastrarNovoFornecedor(Pessoa pessoa) throws Exception{
		boolean tipo = validaTipoFornecedor(pessoa);
		if(tipo == true){
			boolean existe = validaFornecedorExistente(pessoa);
			if (existe == false){
				gerarCodigoFornecedorSequencial();
				boolean adicionar = getListaPessoas().add(pessoa);
				if (!adicionar){
					throw new Exception("Falha ao cadastrar fornecedor. Tente novamente.");
				}
			}
		}
	}

	private int gerarCodigoFornecedorSequencial(){
		return getListaPessoas().isEmpty() ? 1 : getListaPessoas().size() + 1;
	}

	public Fornecedor pesquisarFornecedorPorCnpj(String cnpj) throws Exception{
		for (Pessoa pessoa : listaPessoas) {
			boolean tipo = validaTipoFornecedor(pessoa);
			if (tipo == true){
				Fornecedor forn = (Fornecedor) pessoa;
				if (forn.getCnpj().equals(cnpj)) {
					return forn;
				}
				else{ 
					throw new Exception("Não foi encontrado fornecedor com o CNPJ informado.");
				}
			}
		}
		return null;
	}

	private boolean validaSeTemCompraParaFornecedor(Pessoa pessoa) throws Exception{
		boolean possuiCompra = false;
		Compra compra = new Compra();
		Fornecedor forn = (Fornecedor) pessoa;
		if (compra.getFornecedor() == forn){
			possuiCompra = true;
		}
		return possuiCompra;
	}

	private void removeDaListaFornecedor(Pessoa pessoa) throws Exception{
		Fornecedor forn = (Fornecedor) pessoa;
		for (Pessoa pessoaForn : listaPessoas) {
			Fornecedor auxiliar = (Fornecedor) pessoaForn;
			if (forn.getCnpj().equals(auxiliar.getCnpj())){
				boolean excluir = getListaPessoas().remove(pessoa);
				if (!excluir) {
					throw new Exception("Falha ao excluir fornecedor. Tente novamente.");
				}
			}
		}
	}
	
	public void excluirFornecedorValidandoSeTemCompra(Pessoa pessoa) throws Exception{
		boolean tipo = validaTipoFornecedor(pessoa);
		if (tipo == true){
			boolean	possuiCompra = validaSeTemCompraParaFornecedor(pessoa);
			if(possuiCompra == true){
				throw new Exception("O fornecedor está vinculado à uma compra. Não é possível excluir.");
			}
			else{
				removeDaListaFornecedor(pessoa);
			}
		}
	}
}