package pet_shop.DAO.IRepositorios;

import java.util.List;

import pet_shop.negocio.beans.Consulta;

public interface IRepositorioConsulta {
	
	public abstract void cadastrar (Consulta c);
	public abstract Consulta procurar (long id);
	public abstract int procurarID(long id);
	public abstract List<Consulta> procurarIDReservada(long id);
	public abstract boolean existe(Consulta a);
	public abstract List<Consulta> procurar(String nome);

}
