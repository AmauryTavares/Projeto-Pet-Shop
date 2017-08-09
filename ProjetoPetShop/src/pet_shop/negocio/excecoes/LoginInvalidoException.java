package pet_shop.negocio.excecoes;

public class LoginInvalidoException extends Exception{

	public LoginInvalidoException() {
		super("Login inválido!");
	}
}
