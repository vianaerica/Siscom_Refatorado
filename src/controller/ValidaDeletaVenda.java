package controller;

import model.ItemVenda;
import model.Venda;

public class ValidaDeletaVenda {
	public void verificaVendaExistenteEAdicionaEstoque(Venda venda) throws Exception{
		if (venda == null) {
			throw new Exception("Não foi encontrada venda com o número informado.");
		}
		else{ 
			for (ItemVenda item : venda.getVendaItens()) {
				item.getProduto().adicionaQuantidadeDeProdutoNoEstoque(item.getQuantVenda());
			}
		}
	}
}