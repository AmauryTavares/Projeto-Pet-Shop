package pet_shop.DAO.IRepositorios;

import java.util.ArrayList;

import pet_shop.negocio.beans.Produto;

public interface IRepositorioProduto {
	
	public abstract void cadastrar (Produto p);
	public abstract void excluir (long id);
	public abstract Produto procurar (long id);
	public abstract void alterar (Produto newProduto, long id);
	public abstract ArrayList<Produto> listarTudo ();
	public abstract boolean existe(Produto p);
	public abstract boolean existe(long id);

}
