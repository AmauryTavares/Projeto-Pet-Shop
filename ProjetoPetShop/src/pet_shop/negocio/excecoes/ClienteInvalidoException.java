package pet_shop.negocio.excecoes;

public class ClienteInvalidoException extends Exception{

	public ClienteInvalidoException() {
		super("Cliente inválido!");
	}
}
