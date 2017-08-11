package pet_shop.negocio.beans;

import java.io.Serializable;

public class Produto implements Serializable{

	private static final long serialVersionUID = -1186909563420929568L;
	private long id;
	private String nome;
	private double preco;
	private double qtdEstoque;
	
	public Produto(String nome, double preco, double qtdEstoque) {
		this.nome = nome;
		this.preco = preco;
		this.qtdEstoque = qtdEstoque;
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
	public double getQtdEstoque() {
		return qtdEstoque;
	}
	public void setQtdEstoque(double qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "\nNome do produto: " + this.nome + "\nPreço: R$" + String.format("%.2f", this.preco) + "\nQuantidade: " + this.qtdEstoque + " u/kg";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preco != other.preco)
			return false;
		if (qtdEstoque != other.qtdEstoque)
			return false;
		return true;
	}

	
	
}
