package pet_shop.negocio.excecoes;

public class EmailInvalidoException extends Exception{

	public EmailInvalidoException() {
		super("Email inválido!");
	}
}
