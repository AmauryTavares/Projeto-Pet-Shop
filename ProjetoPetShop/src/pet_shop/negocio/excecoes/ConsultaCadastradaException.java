package pet_shop.negocio.excecoes;

public class ConsultaCadastradaException extends Exception{

	public ConsultaCadastradaException() {
		super("Consulta já cadastrada!");
	}
}
