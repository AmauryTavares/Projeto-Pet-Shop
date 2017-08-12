package pet_shop.negocio.excecoes;

public class PessoaCadastradoException extends Exception{

	private String pessoa;
	private String cpf;
	
	public PessoaCadastradoException(String pessoa, String cpf) {
		super("Cliente/Funcion�rio " + pessoa +", CPF: " + cpf + " j� cadastrado!");
		this.pessoa = pessoa;
		this.cpf = cpf;
	}

	public String getPessoa() {
		return pessoa;
	}

	public String getCpf() {
		return cpf;
	}
	
}
