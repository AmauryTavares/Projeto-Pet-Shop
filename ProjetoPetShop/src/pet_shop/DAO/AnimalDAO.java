package pet_shop.DAO;

import pet_shop.negocio.beans.Animal;

public class AnimalDAO extends RepositorioAbstrato<Animal>{

	private static AnimalDAO instance;
	
	private AnimalDAO() {
		super();
	}
	
	public static AnimalDAO getInstance() {
		if (instance == null) {
			instance = new AnimalDAO();
		}
		return instance;
	}
		
	public Animal listarAnimal(long id) {
		boolean achou = false;
		Animal busca = null;
		for (int i = 0; i < this.elements.size() && achou == false; i++) {
			if (this.elements.get(i).getId() == id) {
				busca = this.elements.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
}
