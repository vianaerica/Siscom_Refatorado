package controller;

import java.util.ArrayList;
import model.Compra;

public class DeletaCompra {
	private ArrayList<Compra> listaCompras = new ArrayList<Compra>();
	private PesquisaCompra pesquisaCompra = new PesquisaCompra();
	private ValidaDeletaCompra valida = new ValidaDeletaCompra();

	public void excluirCompraPeloNumCompra(int numCompra) throws Exception{
		Compra compra = pesquisaCompra.pesquisarCompraPeloNumCompra(numCompra);
		valida.verificaCompraExistenteEDrecrementaEstoque(compra);
		listaCompras.remove(compra);
	}
}