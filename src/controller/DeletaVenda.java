package controller;

import java.util.ArrayList;
import model.Venda;

public class DeletaVenda {
	private ArrayList<Venda> listaVendas = new ArrayList<Venda>();
	private PesquisaVenda pesquisa = new PesquisaVenda();
	private ValidaDeletaVenda valida = new ValidaDeletaVenda();

	public void excluirVendaPeloNumVenda(int numVenda) throws Exception{
		Venda venda = pesquisa.pesquisarVendaPeloNumVenda(numVenda);
		valida.verificaVendaExistenteEAdicionaEstoque(venda);		
		listaVendas.remove(venda);
	}
}