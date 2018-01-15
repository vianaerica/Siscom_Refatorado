package controller;

import java.util.ArrayList;
import model.Produto;

public class CadastroProduto {
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	private ValidaCadastroProduto valida = new ValidaCadastroProduto(listaProdutos);

	public void cadastrarNovoProduto(Produto produto) throws Exception {
		valida.validaProdutoExistente(produto);
		listaProdutos.add(produto);
	}
}