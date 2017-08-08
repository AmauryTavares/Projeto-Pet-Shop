package pet_shop.negocio.excecoes;

public class AnimalCadastradoException extends Exception {

	private String nomeAnimal;
	
	public AnimalCadastradoException(String nomeAnimal) {
		super("O animal " + nomeAnimal + " já está cadastrado!");
		this.nomeAnimal = nomeAnimal;
	}
	
	public String getNomeAnimal() {
		return this.nomeAnimal;
	}
}
