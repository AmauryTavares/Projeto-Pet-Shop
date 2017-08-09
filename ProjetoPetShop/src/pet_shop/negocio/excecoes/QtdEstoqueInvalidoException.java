package pet_shop.negocio.excecoes;

public class QtdEstoqueInvalidoException extends Exception{

	public QtdEstoqueInvalidoException() {
		super("Quantidade de estoque inválida!");
	}
}
