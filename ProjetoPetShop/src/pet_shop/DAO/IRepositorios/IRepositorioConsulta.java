package pet_shop.DAO.IRepositorios;

import java.util.ArrayList;

import pet_shop.negocio.beans.Consulta;

public interface IRepositorioConsulta {
	
	public abstract void cadastrar (Consulta c);
	public abstract void excluir (long id);
	public abstract Consulta procurar (long id);
	public abstract void alterar (Consulta newConsulta, long id);
	public abstract ArrayList<Consulta> listarTudo ();
	public abstract boolean existe(Consulta c);
	public abstract boolean existe(long id);
	
	public abstract boolean existeReservada(long id);
	public abstract int procurarIDReservada(long id);
	public abstract void excluirAgendaPorPosicao(int i);

}
