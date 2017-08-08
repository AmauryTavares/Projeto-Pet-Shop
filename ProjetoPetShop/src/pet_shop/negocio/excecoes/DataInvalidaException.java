package pet_shop.negocio.excecoes;

public class DataInvalidaException extends Exception {

	public DataInvalidaException() {
		super("A data informada está inválida!");
	}
}
