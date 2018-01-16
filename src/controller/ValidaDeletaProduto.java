package controller;

import java.util.ArrayList;
import model.Compra;
import model.ItemCompra;
import model.ItemVenda;
import model.Produto;
import model.Venda;

public class ValidaDeletaProduto {
	private ArrayList<Compra> listaCompras = new ArrayList<Compra>();
	private ArrayList<Venda> listaVendas = new ArrayList<Venda>();

	public void validaProdutoAntesDeExcluir(Produto produto, int codigo) throws Exception{
		if (produto == null) {
			throw new Exception("N�o foi encontrado produto com o c�digo informado.");
		} else{
			validaProdutoVinculadoACompra(codigo);
			validaProdutoVinculadoAVenda(codigo);
		}	
	}

	private void validaProdutoVinculadoACompra(int codigo) throws Exception{
		for (Compra compra : listaCompras) {
			for (ItemCompra item : compra.getCompraItens()){
				if (item.getProduto().getCodigo() == codigo) {
					throw new Exception("N�o � poss�vel excluir este produto. Ele est� vinculado a uma COMPRA.");
				}
			}
		}
	}

	private void validaProdutoVinculadoAVenda(int codigo) throws Exception{
		for (Venda venda : listaVendas) {
			for (ItemVenda item : venda.getVendaItens()) {
				if (item.getProduto().getCodigo() == codigo) {
					throw new Exception("N�o � poss�vel excluir este produto. Ele est� vinculado a uma VENDA.");
				}
			}
		}
	}
}