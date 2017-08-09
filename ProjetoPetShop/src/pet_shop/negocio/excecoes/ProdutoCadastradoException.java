package pet_shop.negocio.excecoes;

public class ProdutoCadastradoException extends Exception{

	private String nome;
	
	public ProdutoCadastradoException(String nome) {
		super("Produto " + nome + " já cadastrado!");
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
