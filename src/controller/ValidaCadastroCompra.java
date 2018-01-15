package controller;

public class ValidaCadastroCompra {

	public void validaItensDuplicados(int qtd) throws Exception{
		if (qtd > 1) {
			throw new Exception("A compra possui produtos duplicados.");
		}
	}
}