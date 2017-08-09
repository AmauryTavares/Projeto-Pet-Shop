package pet_shop.negocio.excecoes;

public class ProdutoInvalidoException extends Exception{

	public ProdutoInvalidoException() {
		super("Produto inválido!");
	}
}
