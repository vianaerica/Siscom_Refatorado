package controller;

import java.util.ArrayList;
import model.Compra;
import model.ItemCompra;

public class DeletaCompra {
	private ArrayList<Compra> listaCompras = new ArrayList<Compra>();
	private PesquisaCompra pesquisaCompra = new PesquisaCompra();
	
	public void excluirCompraPeloNumCompra(int numCompra) throws Exception{
		Compra compra = pesquisaCompra.pesquisarCompraPeloNumCompra(numCompra);
		//verifica se existe compra com o parametro informado
		if (compra == null) {
			throw new Exception("Não foi encontrada compra com o número informado.");
		}
		else{ //se existir deleta e decrementa do estoque
			for (ItemCompra item : compra.getCompraItens()) {
				item.getProduto().decrementaQuantidadeDeProdutoNoEstoque(item.getQuantCompra());
			}
			listaCompras.remove(compra);
		}
	}
}