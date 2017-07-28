package pet_shop.DAO.IRepositorios;

import java.util.ArrayList;

import pet_shop.negocio.beans.Agenda;

public interface IRepositorioAgenda {
	
	public abstract void cadastrar (Agenda a);
	public abstract void excluir (long id);
	public abstract Agenda procurar (long id);
	public abstract void alterar (Agenda newAgenda, long id);
	public abstract ArrayList<Agenda> listarTudo ();
	public abstract boolean existe(Agenda a);
	public abstract boolean existe(long id);
	
	public abstract boolean existeReservada(long id);
	public abstract int procurarIDReservada(long id);
	public abstract void excluirAgendaPorPosicao(int i);

}
