package controller;

import model.ItemVenda;

public class ValidaCadastroVenda {

	public void validaItensDuplicados(int qtd) throws Exception{
		if (qtd > 1) {
			throw new Exception("A venda possui produtos duplicados.");
		}
	}
	
	public void validaFormaDePgto() throws Exception{
		if (formaPagto == 2) {
			double total = 0;

			for (ItemVenda itemVenda : itens) {
				total = total + itemVenda.getValorVenda();
			}

			if (total > cliente.getLimiteCredito()) {
				throw new Exception("O cliente não possui limite de crédito suficiente. Escolha outra opção de pagamento.");
			}
		}
	}
}
