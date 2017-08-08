package pet_shop.DAO;

import java.util.ArrayList;
import java.util.List;

import pet_shop.DAO.IRepositorios.IRepositorioAnimal;
import pet_shop.negocio.beans.Animal;

public class AnimalDAO extends RepositorioAbstrato<Animal> implements IRepositorioAnimal{
	
	private static AnimalDAO instance;
	private static long proximoID = 0;
	
	private AnimalDAO() {
		super();
		proximoID = this.list.get(this.list.size() - 1).getId();
	}
	
	public static AnimalDAO getInstance() {
		if (instance == null) {
			instance = new AnimalDAO();
		}
		return instance;
	}

	@Override
	public void cadastrar(Animal a) {
		if(!this.list.contains(a)) {
			a.setId(proximoID++);
			this.list.add(a);
		}
	}
	
	@Override
	public Animal procurar(long id) {
		Animal busca = null;
		
		int indice = procurarID(id);
		if(indice != this.list.size()) {
			busca = this.list.get(indice);
		}
		
		return busca;
	}
	
	@Override
	public List<Animal> procurar(String nome) {
		List<Animal> lista = new ArrayList<>();

		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).getNome().equals(nome)) {
				lista.add(this.list.get(i));
			}	
		}
		
		return lista;
	}

	@Override
	public int procurarID(long id) { //procura pela reserva do cliente
		boolean achou = false;
		int i;
		
		for (i = 0; i < this.list.size() && !achou; i++) {
			if (this.list.get(i).getId() == id) {
				achou = true;
			}	
		}
		return i;
	}

	@Override
	public boolean existe(Animal a) {
		if (this.list.contains(a)) {
			return true;
		}
		return false;
	}
	
}
