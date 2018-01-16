package controller;

import model.Compra;
import model.ItemCompra;

public class ValidaDeletaCompra {
	public void verificaCompraExistenteEDrecrementaEstoque(Compra compra) throws Exception{
		if (compra == null) {
			throw new Exception("Não foi encontrada compra com o número informado.");
		}
		else{
			for (ItemCompra item : compra.getCompraItens()) {
				item.getProduto().decrementaQuantidadeDeProdutoNoEstoque(item.getQuantCompra());
			}
		}
	}
}