package pet_shop.negocio.excecoes;

public class NomeInvalidoException extends Exception{

	public NomeInvalidoException() {
		super("O nome informado está inválido!");
	}
}
