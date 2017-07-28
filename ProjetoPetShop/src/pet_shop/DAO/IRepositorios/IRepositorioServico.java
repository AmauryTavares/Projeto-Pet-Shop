package pet_shop.DAO.IRepositorios;

import java.util.ArrayList;

import pet_shop.negocio.beans.Servico;

public interface IRepositorioServico {
	
	public abstract void cadastrar (Servico s);
	public abstract void excluir (long id);
	public abstract Servico procurar (long id);
	public abstract void alterar (Servico newServico, long id);
	public abstract ArrayList<Servico> listarTudo ();
	public abstract boolean existe(Servico s);
	public abstract boolean existe(long id);

}
