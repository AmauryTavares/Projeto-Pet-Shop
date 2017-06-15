package br.ufrpe.social_network.dao;

import java.util.Arrays;

import br.ufrpe.social_network.negocio.beans.Person;

public class PersonDAO {

	private Person[] repositorioPerson;
	private static PersonDAO instance;
	private static int proximaPosicao = 0;

	private PersonDAO() {
		this.repositorioPerson = new Person[100];
	}

	public static PersonDAO getInstance() {
		if (instance == null) {
			instance = new PersonDAO();
		}
		return instance;
	}

	public void cadastrar(Person p) {
		boolean verificar = false;
		while (verificar == false) {
			if (proximaPosicao < this.repositorioPerson.length) {
				this.repositorioPerson[proximaPosicao] = p;
				proximaPosicao++;
				verificar = true;
			} else {
				duplicarArray();
			}
		}

	}

	public void alterar(Person p) {
		int idInt = (int) p.getId();
		int posicao = procurarIndice(idInt); // procura a posição da pessoa no array								
		if (posicao != proximaPosicao) {
			this.repositorioPerson[posicao] = p;
		}
	}

	public void excluir(long id) {
		int idInt = (int) id;
		int posicao = procurarIndice(idInt);
		if (posicao != proximaPosicao) {
			this.repositorioPerson[posicao] = this.repositorioPerson[proximaPosicao - 1];
			Arrays.sort(this.repositorioPerson); // ******testar
			proximaPosicao--;
		}
	}

	public Person listar(long id) {
		Person busca = null;
		boolean verificar = false;

		for (int i = 0; i < proximaPosicao && verificar == false; i++) {
			if (this.repositorioPerson[i].getId() == id) {
				busca = this.repositorioPerson[i];
				verificar = true;
			}
		}
		return busca;
	}

	public Person[] listarTudo() {
		return this.repositorioPerson;
	}

	private int procurarIndice(long id) {
		int i;
		for (i = 0; i < proximaPosicao; i++) {
			if (id == this.repositorioPerson[i].getId()) {
				return i;
			}
		}
		return i;
	}

	private void duplicarArray() {
		if (this.repositorioPerson != null && this.repositorioPerson.length > 0) {
			Person[] novoRepositorio = new Person[2 * this.repositorioPerson.length];
			for (int i = 0; i < this.repositorioPerson.length; i++) {
				novoRepositorio[i] = this.repositorioPerson[i];
			}
			this.repositorioPerson = novoRepositorio;
		}
	}

	public boolean existe(Person p) {
		boolean resultado = false;
		for (int i = 0; i < this.repositorioPerson.length && resultado == false; i++) {
			if(p.equals(this.repositorioPerson[i])) {
				resultado = true;
			}
		}
		return resultado;
	}
}
