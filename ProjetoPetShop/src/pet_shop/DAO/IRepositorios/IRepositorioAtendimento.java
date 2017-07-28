package pet_shop.DAO.IRepositorios;

import java.util.ArrayList;

import pet_shop.negocio.beans.Atendimento;

public interface IRepositorioAtendimento {
	
	public abstract void cadastrar (Atendimento a);
	public abstract void excluir (long id);
	public abstract Atendimento procurar (long id);
	public abstract void alterar (Atendimento newAtendimento, long id);
	public abstract ArrayList<Atendimento> listarTudo ();
	public abstract boolean existe(Atendimento a);
	public abstract boolean existe(long id);

}
