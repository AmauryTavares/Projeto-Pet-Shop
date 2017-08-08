package pet_shop.DAO.IRepositorios;

import java.util.List;

import pet_shop.negocio.beans.Servico;

public interface IRepositorioServico {
	
	public abstract void cadastrar (Servico s);
	public abstract Servico procurar (long id);
	public abstract int procurarID(long id);
	public abstract boolean existe(Servico a);
	public abstract List<Servico> procurar(String nome);
	
}
