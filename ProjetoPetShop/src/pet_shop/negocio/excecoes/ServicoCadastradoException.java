package pet_shop.negocio.excecoes;

public class ServicoCadastradoException extends Exception{

	private String nomeServico;
	
	public ServicoCadastradoException(String nomeServico) {
		super("Serviço " + nomeServico + " já cadastrado!");
		this.nomeServico = nomeServico;
	}

	public String getNomeServico() {
		return nomeServico;
	}
	
}
