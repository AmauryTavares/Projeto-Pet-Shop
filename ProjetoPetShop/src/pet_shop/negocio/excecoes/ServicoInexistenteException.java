package pet_shop.negocio.excecoes;

public class ServicoInexistenteException extends Exception{

	public ServicoInexistenteException() {
		super("Serviço inexistente!");
	}
}
