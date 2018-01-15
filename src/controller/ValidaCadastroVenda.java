package controller;

import java.util.ArrayList;
import model.Cliente;
import model.ItemVenda;

public class ValidaCadastroVenda {
	
	public void validaFormaDePgto(int formaPagto, ArrayList<ItemVenda> itens, Cliente cliente) throws Exception{
		if (formaPagto == 2) {
			double total = 0;

			for (ItemVenda itemVenda : itens) {
				total = total + itemVenda.getValorVenda();
			}

			if (total > cliente.getLimiteCredito()) {
				throw new Exception("O cliente n�o possui limite de cr�dito suficiente. Escolha outra op��o de pagamento.");
			}
		}
	}
}