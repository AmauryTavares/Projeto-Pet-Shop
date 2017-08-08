package pet_shop.negocio.excecoes;

public class AnimalInexistenteException extends Exception {

	public AnimalInexistenteException() {
		super("Animal inexistente!");
	}
}
