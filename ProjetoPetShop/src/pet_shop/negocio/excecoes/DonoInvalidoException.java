package pet_shop.negocio.excecoes;

public class DonoInvalidoException extends Exception {

	public DonoInvalidoException() {
		super("O dono do animal é inválido!");
	}
}
