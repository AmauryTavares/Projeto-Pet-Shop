package pet_shop.negocio.excecoes;

public class PessoaInexistenteException extends Exception{

	public PessoaInexistenteException() {
		super("Cliente/Funcion�rio inexistente!");
	}
}
