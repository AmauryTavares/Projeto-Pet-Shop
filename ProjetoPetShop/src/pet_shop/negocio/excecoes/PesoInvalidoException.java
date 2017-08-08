package pet_shop.negocio.excecoes;

public class PesoInvalidoException extends Exception {

	public PesoInvalidoException() {
		super("O peso do animal é inválido!");
	}
}
