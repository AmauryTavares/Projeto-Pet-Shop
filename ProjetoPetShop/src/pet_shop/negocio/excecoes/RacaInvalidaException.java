package pet_shop.negocio.excecoes;

public class RacaInvalidaException extends Exception {

	public RacaInvalidaException() {
		super("A raça do animal é inválida!");
	}
}
