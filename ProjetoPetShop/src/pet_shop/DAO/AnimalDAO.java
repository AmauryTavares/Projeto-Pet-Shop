package pet_shop.DAO;

import java.util.ArrayList;

import pet_shop.DAO.IRepositorios.IRepositorioAnimal;
import pet_shop.negocio.beans.Animal;

public class AnimalDAO implements IRepositorioAnimal{
	
	private ArrayList<Animal> repositorioAnimal;
	private static AnimalDAO instance;
	
	private AnimalDAO() {
		this.repositorioAnimal = new ArrayList<>();
	}
	
	public static AnimalDAO getInstance() {
		if (instance == null) {
			instance = new AnimalDAO();
		}
		return instance;
	}
	
	@Override
	public void cadastrar(Animal a) {
		this.repositorioAnimal.add(a);
	}

	@Override
	public void excluir(long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioAnimal.size()) {
			this.repositorioAnimal.remove(indice);
		}
	}

	@Override
	public Animal procurar(long id) {
		Animal busca = null;
		
		int indice = procurarID(id);
		if(indice != this.repositorioAnimal.size()) {
			busca = this.repositorioAnimal.get(indice);
		}
		
		return busca;
	}

	@Override
	public void alterar(Animal newAnimal, long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioAnimal.size()) {
			this.repositorioAnimal.remove(indice);
			this.repositorioAnimal.add(indice, newAnimal);
		}		
	}

	@Override
	public ArrayList<Animal> listarTudo() {
		return this.repositorioAnimal;
	}
	
	public int procurarID(long id) { //procura pela reserva do cliente
		
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i < this.repositorioAnimal.size())) {
			
			if(this.repositorioAnimal.get(i).getId() == id) {
				achou = true;
			} else {
				i++;
			}
			
		}
		
		return i;
		
	}

	@Override
	public boolean existe(Animal a) {
		return this.repositorioAnimal.contains(a);
	}

	@Override
	public boolean existe(long id) {
		boolean existe = false;
		int i = procurarID(id);
		
		if(i != this.repositorioAnimal.size()) {
			existe = true;
		}
		
		return existe;
	}
	
}
