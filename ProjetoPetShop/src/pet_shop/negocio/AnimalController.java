package pet_shop.negocio;

import java.util.ArrayList;

import pet_shop.DAO.AnimalDAO;
import pet_shop.DAO.IRepositorios.IRepositorioAnimal;
import pet_shop.negocio.beans.Animal;

public class AnimalController {
	
	private IRepositorioAnimal animalRepository;
	private static AnimalController instance;
	
	//Singleton
	private AnimalController() {
		this.animalRepository = AnimalDAO.getInstance();
	}
	
	public static AnimalController getInstance() {
		if(instance == null) {
			instance = new AnimalController();
		}
		return instance;
	}
	
	//Controle dos métodos do repositório
	public void saveAnimal(Animal animal) {
		
		if( (animal != null) && (!this.animalRepository.existe(animal)) && (animal.getDono() != null) 
				&& (animal.getDataNascimento() != null) && (animal.getEspecie() != null) 
				&& (animal.getNome() != null) && (animal.getPeso() > 0) && (animal.getRaca() != null) ) {
			
			this.animalRepository.cadastrar(animal);
		}
		
	}
	
	public void updateAnimal(Animal newAnimal, long id) {
		
		if(newAnimal != null) {
			Animal a = this.animalRepository.procurar(id);
			
			if( (a != null) && (newAnimal.getDataNascimento() != null) && (newAnimal.getDono() != null) && (newAnimal.getEspecie() != null) 
					&& (newAnimal.getNome() != null) && (newAnimal.getPeso() > 0) && (newAnimal.getRaca() != null)) {
				
				this.animalRepository.alterar(newAnimal, id);
			}
		}
		
	}
	
	public void deleteAnimal(long id) {
		
		if(id >= 0 && this.animalRepository.existe(id)) {
			this.animalRepository.excluir(id);
		}
		
	}
	
	public Animal findAnimal(long id) {
		
		if(id >= 0 && this.animalRepository.existe(id)) {
			return this.animalRepository.procurar(id);
		} else {
			return null;
		}
		
	}
	
	public ArrayList<Animal> listarTodosAnimais() {
		return this.animalRepository.listarTudo();	
	}

}
