package pet_shop.negocio.excecoes;

public class PessoaCadastradoException extends Exception{

	private String pessoa;
	private String cpf;
	
	public PessoaCadastradoException(String pessoa, String cpf) {
		super("Cliente/Funcionário" + pessoa +", CPF: " + cpf + "já cadastrado!");
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
