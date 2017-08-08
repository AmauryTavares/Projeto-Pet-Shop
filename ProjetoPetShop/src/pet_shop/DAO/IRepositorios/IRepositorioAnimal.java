package pet_shop.DAO.IRepositorios;

import java.util.List;

import pet_shop.negocio.beans.Animal;

public interface IRepositorioAnimal {
	
	public abstract void cadastrar(Animal a);
	public abstract Animal procurar (long id);
	public abstract int procurarID(long id);
	public abstract boolean existe(Animal a);
	public abstract List<Animal> procurar(String nome);
	
}
