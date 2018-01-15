package controller;

import java.util.ArrayList;
import model.Venda;

public class PesquisaVenda {
	private ArrayList<Venda> listaVendas = new ArrayList<Venda>();

	public Venda pesquisarVendaPeloNumVenda(int numVenda) throws Exception{
		for (Venda venda : listaVendas) {
			if (venda.getNumVenda() == numVenda) {
				return venda;
			}
			else{ 
				throw new Exception("N�o foi encontrada venda com o n�mero informado.");
			}
		}
		return null;
	}
}