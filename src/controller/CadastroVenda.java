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
		incluirItensNaListaItemVenda(itens);
		valida.validaFormaDePgto(formaPagto, itens, cliente);
		decrementarQuantidadeNoEstoque(itens);

		Venda venda = new Venda();

		venda = new Venda(1, cliente, vendedor, itens, formaPagto, new Date());	
		listaVendas.add(venda);
	}

	private void incluirItensNaListaItemVenda(ArrayList<ItemVenda> itens) throws Exception{
		for (ItemVenda itemVenda : itens) {
			int qtd = 0;
			for (ItemVenda item : itens) {
				if (item.getProduto().getCodigo() == itemVenda.getProduto().getCodigo()) {
					qtd++;
					validaItensDuplicados(qtd);
				}
			}
		}
	}

	private void validaItensDuplicados(int qtd) throws Exception{
		if (qtd > 1) {
			throw new Exception("A venda possui produtos duplicados.");
		}
	}

	private void decrementarQuantidadeNoEstoque(ArrayList<ItemVenda> itens){
		for (ItemVenda itemVenda : itens) {
			itemVenda.getProduto().decrementaQuantidadeDeProdutoNoEstoque(itemVenda.getQuantVenda());
		}
	}
}