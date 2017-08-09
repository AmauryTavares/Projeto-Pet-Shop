package pet_shop.negocio.excecoes;

public class AtendimentoInexistenteException extends Exception{

	public AtendimentoInexistenteException() {
		super("Atendimento inválido!");
	}
}
