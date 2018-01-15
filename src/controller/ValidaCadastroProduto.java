package controller;

import java.util.ArrayList;
import model.Produto;

public class ValidaCadastroProduto {

	private ArrayList<Produto> listaProdutos;

	public ValidaCadastroProduto(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public void validaProdutoExistente(Produto produto) throws Exception{
		for (Produto prd : listaProdutos){
			if(prd.getNome().equals(produto)){
				throw new Exception("O produto informado já está cadastrado na lista.");
			}
		}
	}
}