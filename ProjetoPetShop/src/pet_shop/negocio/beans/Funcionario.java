package pet_shop.negocio.beans;

public class Funcionario extends Pessoa{

	private String login;
	private String senha;
	private double salario;
	private String cargo;

	public Funcionario(String nome, String cpf, Endereco endereco, String email,
			String telefone, String login, String senha, double salario, String cargo) {
		super(nome, cpf, endereco, email, telefone);
		this.login = login;
		this.senha = senha;
		this.salario = salario;
		this.cargo = cargo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String toString() {
		return "ID: " + this.id + "\nNome: " + this.nome + "\nCPF: " + this.cpf + "\nEndereco: " + this.endereco + 
				"\nEmail: " + this.email + "\nTelefone: " + this.telefone + "\nCargo: " + this.cargo + "\nSalário: R$" + String.format("%.2f", this.salario) ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (salario != other.salario)
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	
}
