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
				throw new Exception("Não foi encontrada compra com o número informado.");
			}
		}
		return null;
	}
}