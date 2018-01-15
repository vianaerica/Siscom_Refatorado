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
				throw new Exception("N�o foi encontrado produto com o c�digo informado.");
			}
		}
		return null;
	}
}