package pet_shop.negocio.beans;

import java.io.Serializable;

public class Servico implements Serializable{

	private static final long serialVersionUID = 7453463179631013178L;
	private long id;
	private String nome;
	private double preco;
	private boolean necessitaConsulta;
	
	public Servico(String nome, double preco, boolean consulta) {
		this.nome = nome;
		this.preco = preco;
		this.necessitaConsulta = consulta;
		
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public boolean isConsulta() {
		return necessitaConsulta;
	}

	public void setConsulta(boolean consulta) {
		this.necessitaConsulta = consulta;
	}

	@Override
	public String toString() {
		String text ="ID: " + this.id + "\nNome do produto: " + this.nome + "\nPreço: R$" + String.format("%.2f", this.preco) +
				 "\nConsulta: ";
		
		if (this.necessitaConsulta == true) {
			text += "Sim";
		} else {
			text += "Não";
		}
		
		return text;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		if (necessitaConsulta != other.necessitaConsulta)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		return true;
	}

}
