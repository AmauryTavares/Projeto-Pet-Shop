package pet_shop.negocio.excecoes;

public class SenhaInvalidaException extends Exception{

	public SenhaInvalidaException() {
		super("Senha inválida!");
	}
}
