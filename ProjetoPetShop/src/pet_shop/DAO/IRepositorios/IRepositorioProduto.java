package pet_shop.DAO.IRepositorios;

import java.util.List;

import pet_shop.negocio.beans.Produto;

public interface IRepositorioProduto {
	
	public abstract void cadastrar (Produto p);
	public abstract Produto procurar (long id);
	public abstract int procurarID(long id);
	public abstract boolean existe(Produto a);
	public abstract List<Produto> procurar(String nome);
	
}
