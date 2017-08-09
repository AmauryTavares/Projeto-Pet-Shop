package pet_shop.negocio.excecoes;

public class ConsultaInexistenteException extends Exception{

	public ConsultaInexistenteException() {
		super("Consulta inexistente!");
	}
}
