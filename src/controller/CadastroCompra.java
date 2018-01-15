package controller;

import java.util.ArrayList;
import java.util.Date;
import model.Compra;
import model.Fornecedor;
import model.ItemCompra;

public class CadastroCompra {
	private ArrayList<Compra> listaCompras = new ArrayList<Compra>();
	private ValidaCadastroCompra valida = new ValidaCadastroCompra();

	public void inserirNovaCompra(Fornecedor fornecedor, ArrayList<ItemCompra> itens) throws Exception {
		incluirItensNaListaCompra(itens);
	
		Compra compra = new Compra();
		compra = new Compra(fornecedor, itens, 1, new Date());

		incrementaQuantidadeNoEstoque(itens);
		
		listaCompras.add(compra);
	}

	private void incluirItensNaListaCompra(ArrayList<ItemCompra> itens) throws Exception{
		for (ItemCompra itemCompra : itens) {
			int qtd = 0;

			for (ItemCompra item : itens) {
				if (item.getProduto().getCodigo() == itemCompra.getProduto().getCodigo()) {
					qtd++;
				}
			}
			valida.validaItensDuplicados(qtd);
		}
	}
	
	private void incrementaQuantidadeNoEstoque(ArrayList<ItemCompra> itens){
		for (ItemCompra itemCompra : itens) {
			itemCompra.getProduto().adicionaQuantidadeDeProdutoNoEstoque(itemCompra.getQuantCompra());
		}
	}
}