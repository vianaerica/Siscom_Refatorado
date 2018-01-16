package controller;

import java.util.ArrayList;
import model.Produto;

public class DeletaProduto {
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	private PesquisaProduto pesquisa = new PesquisaProduto();
	private ValidaDeletaProduto valida = new ValidaDeletaProduto();

	public void excluirProdutoPeloCodigo(int codigo) throws Exception{
		Produto produto = pesquisa.pesquisarProdutoPorCodigo(codigo);
		valida.validaProdutoAntesDeExcluir(produto, codigo);
		listaProdutos.remove(produto);
	}
}