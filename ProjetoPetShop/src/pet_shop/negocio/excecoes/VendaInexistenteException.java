package pet_shop.negocio.excecoes;

public class VendaInexistenteException extends Exception{

	public VendaInexistenteException() {
		super("Venda inexistente!");
	}
}
