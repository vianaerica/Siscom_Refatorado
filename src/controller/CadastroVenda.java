package controller;

import java.util.ArrayList;
import java.util.Date;
import model.Cliente;
import model.ItemVenda;
import model.Venda;
import model.Vendedor;

public class CadastroVenda {
	private ArrayList<Venda> listaVendas = new ArrayList<Venda>();
	private ValidaCadastroVenda valida = new ValidaCadastroVenda();


	public void cadastrarNovaVenda(Cliente cliente, Vendedor vendedor, int formaPagto, ArrayList<ItemVenda> itens) throws Exception {
		incluirItensNaListaItemVenda();
		valida.validaFormaDePgto();
		decrementarQuantidadeNoEstoque();

		Venda venda = new Venda();

		venda = new Venda(1, cliente, vendedor, itens, formaPagto, new Date());	
		listaVendas.add(venda);
	}

	private void incluirItensNaListaItemVenda(){
		for (ItemVenda itemVenda : itens) {
			int qtd = 0;
			for (ItemVenda item : itens) {
				if (item.getProduto().getCodigo() == itemVenda.getProduto().getCodigo()) {
					qtd++;
					valida.validaItensDuplicados(qtd);
				}
			}
		}
	}

	private void decrementarQuantidadeNoEstoque(){
		for (ItemVenda itemVenda : itens) {
			itemVenda.getProduto().decrementaQuantidadeDeProdutoNoEstoque(itemVenda.getQuantVenda());
		}
	}
}
