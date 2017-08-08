package pet_shop.negocio.excecoes;

public class NadaEncontradoException extends Exception{

	public NadaEncontradoException() {
		super("Nada foi encontrado!");
	}
}
