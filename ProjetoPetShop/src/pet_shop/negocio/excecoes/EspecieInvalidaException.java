package pet_shop.negocio.excecoes;

public class EspecieInvalidaException extends Exception {

	public EspecieInvalidaException() {
		super("A espécie do animal é inválida!");
	}
}
