package pet_shop.negocio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Animal {
	
	private long id;
	private Cliente dono;
	private String nome;
	private double peso;
	private String especie;
	private String raca;
	private LocalDate dataNascimento;
	
	public Animal(Cliente dono, String nome, double peso, String especie, String raca,
			LocalDate dataNascimento2) {
		this.dono = dono;
		this.nome = nome;
		this.peso = peso;
		this.especie = especie;
		this.raca = raca;
		this.dataNascimento = dataNascimento2;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "ID: " + this.id + "\nNome: " + this.nome + "\nDono: " +this.dono.getNome() + "\nPeso: " + String.format("%.2f", this.peso) + " kg \nEspécie: " + this.especie + 
				"\nRaça: " + this.raca + "\nData de Nascimento: " + this.dataNascimento.format(fmt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (dono == null) {
			if (other.dono != null)
				return false;
		} else if (!dono.equals(other.dono))
			return false;
		if (especie == null) {
			if (other.especie != null)
				return false;
		} else if (!especie.equals(other.especie))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (peso != other.peso)
			return false;
		if (raca == null) {
			if (other.raca != null)
				return false;
		} else if (!raca.equals(other.raca))
			return false;
		return true;
	}

	
	
}
