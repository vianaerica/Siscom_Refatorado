package controller;

import java.util.ArrayList;
import model.Compra;

public class PesquisaCompra {
	private ArrayList<Compra> listaCompras = new ArrayList<Compra>();

	public Compra pesquisarCompraPeloNumCompra(int numCompra) throws Exception{
		for (Compra compra : listaCompras) {
			if (compra.getNumCompra() == numCompra) {
				return compra;
			}
			else{ 
				throw new Exception("N�o foi encontrada compra com o n�mero informado.");
			}
		}
		return null;
	}
}