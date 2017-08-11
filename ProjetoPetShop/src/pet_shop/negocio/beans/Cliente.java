package pet_shop.negocio.beans;

public class Cliente extends Pessoa {

	private static final long serialVersionUID = 8101943546760247726L;

	public Cliente(String nome, String cpf, Endereco endereco, String email, String telefone) {
		super(nome, cpf, endereco, email, telefone);
	}

	@Override
	public String toString() {
		return "ID: " + this.id + "\nNome: " + this.nome + "\nCPF: " + this.cpf + "\nEndereco: " + this.endereco + 
				"\nEmail: " + this.email + "\nTelefone: " + this.telefone;
	}

}
