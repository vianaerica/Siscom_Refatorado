package controller;

import java.util.ArrayList;
import model.Produto;

public class PesquisaProduto {
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	
	public Produto pesquisarProdutoPorCodigo(int codigo) throws Exception{
		for (Produto produto : listaProdutos) {
			if (produto.getCodigo() == codigo) {
				return produto;
			}
			else{ 
				throw new Exception("Não foi encontrado produto com o código informado.");
			}
		}
		return null;
	}
}