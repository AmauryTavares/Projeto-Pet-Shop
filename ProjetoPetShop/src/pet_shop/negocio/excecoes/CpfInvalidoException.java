package pet_shop.negocio.excecoes;

public class CpfInvalidoException extends Exception{

	public CpfInvalidoException() {
		super("CPF inválido!");
	}
}
