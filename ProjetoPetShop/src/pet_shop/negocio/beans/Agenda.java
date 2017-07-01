package pet_shop.negocio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Agenda {

	private static long proximoID = 1;
	
	private long id;
	private Animal animal;
	private LocalDate dataMarcada;
	private ArrayList<Servico> servicos;
	
	public Agenda(Animal animal, LocalDate dataMarcada, ArrayList<Servico> servicos) {
		this.id = proximoID;
		proximoID++;
		this.animal = animal;
		this.dataMarcada = dataMarcada;
		this.servicos = servicos;
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

	public ArrayList<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(ArrayList<Servico> servicos) {
		this.servicos = servicos;
	}

	public long getId() {
		return id;
	}
	
	public void adicionarServico(Servico s) {
		if (s != null) {
			this.servicos.add(s);
		}	
	}
	
	public void removerServico(long id) {
		boolean achou = false;
		for (int i = 0; i < this.servicos.size() && achou == false; i++) {
			if (this.servicos.get(i).getId() == id) {
				this.servicos.remove(i);
				achou = true;
				i--;
			}
		}
	}
	
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String text = "\nID: " + this.id + "\nData: " + this.dataMarcada.format(fmt) + "\nServiço(s): ";
		
		for (int i = 0; i < this.servicos.size(); i++) {
			text += String.format("\n%15s \t%20s \tR$%.2f",this.animal.getNome() , this.servicos.get(i).getNome(), this.servicos.get(i).getPreco());
		}

		return text;
	}

}
