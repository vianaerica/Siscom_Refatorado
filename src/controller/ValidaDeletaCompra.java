package controller;

import model.Compra;
import model.ItemCompra;

public class ValidaDeletaCompra {
	public void verificaCompraExistenteEDrecrementaEstoque(Compra compra) throws Exception{
		if (compra == null) {
			throw new Exception("N�o foi encontrada compra com o n�mero informado.");
		}
		else{
			for (ItemCompra item : compra.getCompraItens()) {
				item.getProduto().decrementaQuantidadeDeProdutoNoEstoque(item.getQuantCompra());
			}
		}
	}
}