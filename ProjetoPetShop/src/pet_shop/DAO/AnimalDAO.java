package pet_shop.DAO;

import java.util.ArrayList;

import pet_shop.negocio.beans.Animal;

public class AnimalDAO {

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
	
	public void cadastrarAnimal(Animal a) {
		this.repositorioAnimal.add(a);
	}
	
	public void alterarAnimal(Animal a, long id) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioAnimal.size() && achou == false; i++) {
			if (this.repositorioAnimal.get(i).getId() == id) {
				this.repositorioAnimal.get(i).setDataNascimento(a.getDataNascimento());
				this.repositorioAnimal.get(i).setDono(a.getDono());
				this.repositorioAnimal.get(i).setEspecie(a.getEspecie());
				this.repositorioAnimal.get(i).setNome(a.getNome());
				this.repositorioAnimal.get(i).setPeso(a.getPeso());
				this.repositorioAnimal.get(i).setRaca(a.getRaca());
				achou = true;
			}
		}
	}
	
	public void excluirAnimal(long id) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioAnimal.size() && achou == false; i++) {
			if (this.repositorioAnimal.get(i).getId() == id) {
				this.repositorioAnimal.remove(i);
				achou = true;
			}
		}
	}
	
	public Animal listarAnimal(long id) {
		boolean achou = false;
		Animal busca = null;
		for (int i = 0; i < this.repositorioAnimal.size() && achou == false; i++) {
			if (this.repositorioAnimal.get(i).getId() == id) {
				busca = this.repositorioAnimal.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
	public ArrayList<Animal> listarTudo() {
		return this.repositorioAnimal;
	}
	
	//método existe em overloading
	public boolean existe(Animal a) {
		boolean verificar = false;
		for (int i = 0; i < this.repositorioAnimal.size() && verificar == false; i++) {
			if (a.equals(this.repositorioAnimal.get(i))) {
				verificar = true;
			}
		}
		return verificar;
	}
	
	public boolean existe(long id) {
		
		boolean existe = false;
		int i = 0;
		
		while((!existe) && (i < this.repositorioAnimal.size())) {
			
			if(id == this.repositorioAnimal.get(i).getId()) {
				existe = true;
			} else {
				i++;
			}
				
		}
		
		return existe;
	}
	
}
