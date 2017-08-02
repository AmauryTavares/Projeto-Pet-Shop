package pet_shop.negocio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Consulta {
	
	private long id;
	private Animal animal;
	private LocalDate dataMarcada;
	private Atendimento atendimento;
	
	public Consulta(Animal animal, LocalDate dataMarcada, Atendimento atendimento) {
		this.animal = animal;
		this.dataMarcada = dataMarcada;
		this.atendimento = atendimento;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public LocalDate getDataMarcada() {
		return dataMarcada;
	}

	public void setDataMarcada(LocalDate dataMarcada) {
		this.dataMarcada = dataMarcada;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String text = "\nID: " + this.id + "\nData: " + this.dataMarcada.format(fmt) + "\nNome do animal: " + this.animal.getNome() + this.atendimento;
		

		return text;
	}

}
