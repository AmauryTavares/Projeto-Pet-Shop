package pet_shop.DAO.IRepositorios;

import java.util.ArrayList;

import pet_shop.negocio.beans.Animal;

public interface IRepositorioAnimal {
	
	public abstract void cadastrar (Animal a);
	public abstract void excluir (long id);
	public abstract Animal procurar (long id);
	public abstract void alterar (Animal newAnimal, long id);
	public abstract ArrayList<Animal> listarTudo ();
	public abstract boolean existe(Animal a);
	public abstract boolean existe(long id);

}
