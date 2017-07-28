package pet_shop.DAO.IRepositorios;

import java.util.ArrayList;

import pet_shop.negocio.beans.Venda;

public interface IRepositorioVenda {
	
	public abstract void cadastrar (Venda v);
	public abstract void excluir (long id);
	public abstract Venda procurar (long id);
	public abstract void alterar (Venda newVenda, long id);
	public abstract ArrayList<Venda> listarTudo ();
	public abstract boolean existe(Venda v);
	public abstract boolean existe(long id);

}
