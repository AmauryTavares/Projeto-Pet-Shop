package pet_shop.negocio.excecoes;

public class ProdutoInexistenteException extends Exception{
	
	public ProdutoInexistenteException() {
		super("Produto inexistente!");
	}
}
